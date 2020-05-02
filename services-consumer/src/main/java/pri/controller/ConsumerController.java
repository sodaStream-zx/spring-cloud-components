package pri.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Twilight
 * @desc
 * @createTime 2020-04-19-10:33
 */
@RestController
@RequestMapping("/consumer")
@Api(tags = "服务消费者")
public class ConsumerController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private Integer times = 0;

    @GetMapping(value = "/getMessage")
    public String producerOneMsg(Integer num) throws InterruptedException {
//        int i = RandomUtils.nextInt(0, 2);
//        TimeUnit.SECONDS.sleep(i);
        log.warn("接受请求次数：{}", times++);
        return "ok";
    }
}
