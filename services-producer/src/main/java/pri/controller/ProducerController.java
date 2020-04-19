package pri.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Twilight
 * @desc
 * @createTime 2020-04-19-10:33
 */
@RestController
@RequestMapping("/producer")
public class ProducerController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private RestTemplate restTemplate;

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
}
