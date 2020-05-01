package pri.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pri.service.ProductService;
import pri.vo.TProduct;

/**
 * @author Twilight
 * @desc
 * @createTime 2020-04-19-10:33
 */
@RestController
@RequestMapping("/producer")
public class ProducerController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    final Object mutx = new Object();

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ProductService productService;

    /**
     * 调用消费者接口
     */
    @GetMapping(value = "/sendMsg")
    public String producerOneMsg(Integer total) {
        for (int i = 0; i < total; i++) {
            String str = restTemplate.getForObject("http://learn-consumer/consumer/getMessage?num=" + i, String.class);
            log.warn("调用接口次数：{}", i);
        }
        return "";
    }

    /**
     * 调用消费者接口
     */
    @GetMapping(value = "/order/{pId}")
    @ApiOperation(value = "下单")
    public String orderOne(@PathVariable(value = "pId") Long pId) {
        synchronized (mutx) {
            TProduct product = productService.orderOne(pId);
            if (product.getpStock() > 0) {
                Integer integer = productService.subOne(pId);
                if (integer > 0) {
                    return "秒杀失败";
                }
            }
        }
        return "秒杀成功";
    }

    /**
     * 调用消费者接口
     */
    @GetMapping(value = "/redis")
    @ApiOperation(value = "cache to redis")
    public String cacheRedis() {
        Integer integer = productService.productTotal();
        //insert to redis
        redisTemplate.opsForValue().set("product-1", integer);
        return "ok";
    }
}
