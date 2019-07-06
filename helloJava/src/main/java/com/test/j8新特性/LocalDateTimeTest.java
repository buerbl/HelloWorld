package com.test.j8新特性;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.util.Date;

/**
 * @author buer
 * create 2019/6/8 18:06
 * description 新时间联系
 */
public class LocalDateTimeTest {
    private final  static Logger logger = LoggerFactory.getLogger(LocalDateTimeTest.class);

    //获取当前时间
    @Test
    public void test(){
        LocalDateTime now = LocalDateTime.now();
        logger.debug("sssss");
        logger.info("当前时间：【{}】", now);
    }

    //date转localdatetime 信你个龟
    @Test
    public void transformTest(){
//        logger.debug("转了之后的时间：", LocalDateTime.from());
    }
}
