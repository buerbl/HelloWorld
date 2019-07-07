package com.test.booleanjava;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author booleanjava
 * Date: 2019/7/4 9:46
 * description:
 */
@ComponentScan(basePackages = "com.test.booleanjava")
@SpringBootApplication
public class BaseApplication extends SpringBootServletInitializer {

}
