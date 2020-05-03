package pri.intercaptors;

import com.alibaba.fastjson.JSON;
import com.configs.conmonsentity.ResultData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * @author Twilight
 * @desc
 * @createTime 2020-05-03-10:21
 */
@Component
public class CustomInterceptor implements HandlerInterceptor {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String remoteAddr = request.getRemoteAddr();
        log.warn("----->>访问ip：{}", remoteAddr);
        Object o = redisTemplate.opsForValue().get(remoteAddr);
        if (o != null) {
            redisTemplate.opsForValue().increment(remoteAddr);
            int num = Integer.parseInt(o.toString());
            if (num >= 10 && num < 15) {
                return responseInfo(response, new ResultData(600, "稍后重试"));
            } else if (num >= 15) {
                //超过次数
                //todo add to banned ips
                return responseInfo(response, new ResultData(500, "ip已被加入黑名单"));
            }
        } else {
            redisTemplate.opsForValue().set(remoteAddr, 1, 20, TimeUnit.SECONDS);
        }
        return true;
    }

    //返回用户信息
    private Boolean responseInfo(HttpServletResponse response, ResultData resultData) throws IOException {
        response.setContentType("application/json");
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setCharacterEncoding("UTF-8");
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(JSON.toJSONString(resultData).getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        return false;
    }
}
