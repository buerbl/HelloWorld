package com.test.concurrentboolean;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.test.concurrentboolean.core")
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

}