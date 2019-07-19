package com.test.booleanjava.helloRS.controller;

import com.test.base.core.util.LogUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author boolean
 * Date: 2019/7/19 10:13
 * description:
 */
@RestController
@RequestMapping("/helloRS/getProperties")
public class GetProperties {
    @Value("sdasad")
    private String sdasad;

    @Value("ss")
    private String ss;

    @RequestMapping("/get")
    public String  get(){

        Assert.notNull(sdasad, "b不能为空");
        Assert.notNull(ss,"b不能为空");


        LogUtil.info("sdasad的值：[{}]", sdasad);
        LogUtil.info("ss：[{}]", ss);
        return "hello, redis"+sdasad+"和"+ss;
    }
}
