package com.test;

import com.test1.util.LogUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HelloJava {
    private final static Logger logger = LoggerFactory.getLogger(HelloJava.class);
    @Test
    public void test(){
        System.out.println("HELLO");
        logger.info("jjjjjjjjj");
        logger.error("ss");
        logger.warn("warn");
        logger.debug("debug");
        LogUtil.debug("sss");
    }
}
