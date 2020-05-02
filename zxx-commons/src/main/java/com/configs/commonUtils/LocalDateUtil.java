package com.configs.commonUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author Twilight
 * @desc
 * @createTime 2020-04-21-19:19
 */
public class LocalDateUtil {
    private static final Logger log = LoggerFactory.getLogger(LocalDateUtil.class);
    public static DateTimeFormatter dateAndTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static DateTimeFormatter noSymbolFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
    public static DateTimeFormatter orderCodeFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmmssS");
    public static DateTimeFormatter dateNoTime = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * 解析日期和 时间
     */
    public static LocalDateTime dateTimeParse(String dateTimeStr) {
        LocalDateTime parse = null;
        try {
            parse = LocalDateTime.parse(dateTimeStr, dateAndTime);
        } catch (Exception e) {
            log.error("abnormal parse datetime {}", e);
        }
        return parse;
    }

    /**
     * 解析日期
     */
    public static LocalDateTime dateParse(String dateStr) {
        LocalDateTime parse = null;
        try {
            parse = LocalDateTime.parse(dateStr, dateNoTime);
        } catch (Exception e) {
            log.error("abnormal parse time {}", e);
        }
        return parse;
    }

    /**
     * 转换为Date
     */
    public static Date parseAndTransferDate(String dateTimeStr) {
        LocalDateTime parse = dateParse(dateTimeStr);
        return Date.from(parse.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 转换为Date
     */
    public static Date transferToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 转换为Date
     */
    public static Date transferToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneOffset.systemDefault()).toInstant());
    }

    /**
     * date to localDateTime
     */
    public static LocalDateTime transferToLDT(Date date) {
        //LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * formatter localDateTime
     */
    public static String formatter(LocalDateTime start) {
        if (start == null) {
            return "";
        }
        return start.format(LocalDateUtil.dateAndTime);
    }

    /**
     * formatter localDate
     */
    public static String formatter(LocalDate start) {
        if (start == null) {
            return "";
        }
        return start.format(LocalDateUtil.dateAndTime);
    }
}
