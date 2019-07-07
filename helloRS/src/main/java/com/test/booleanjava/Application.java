package com.test.booleanjava;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author booleanjava
 * Date: 2019/7/2 19:48
 * description:
 */
@ComponentScan(basePackages = "com.test.booleanjava.helloRS")
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
}
