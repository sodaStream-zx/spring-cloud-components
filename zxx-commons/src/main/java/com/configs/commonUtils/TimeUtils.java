package com.configs.commonUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author zxx
 * @desc
 * @createTime 2019-05-27-下午 2:09
 */
public class TimeUtils {
    private static final Logger log = LoggerFactory.getLogger(TimeUtils.class);

    //休眠工具
    public static void pause(Integer minutes, Integer seconds, Integer mills) {

        try {
            TimeUnit.MINUTES.sleep(minutes);
            TimeUnit.MILLISECONDS.sleep(mills);
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            log.error("线程休眠异常 {}", e);
        }
    }
}
