package com.instai.open.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableZuulProxy
@PropertySource(value = { "classpath:instai.properties" })
public class InstaiOpenZuulApplication {


    public static void main(String[] args) {
        SpringApplication.run(InstaiOpenZuulApplication.class, args);
    }
}
