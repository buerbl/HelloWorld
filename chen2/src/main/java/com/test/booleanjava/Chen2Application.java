package com.test.booleanjava;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author booleanjava
 * Date: 2019/7/2 18:16
 * description: 要放在一个包下面 不然就会报错 启动失败
 */
@ComponentScan(basePackages = "com.test.booleanjava")
@SpringBootApplication
@ImportResource({"classpath:dubbo.xml"})
public class Chen2Application extends SpringBootServletInitializer {
}
