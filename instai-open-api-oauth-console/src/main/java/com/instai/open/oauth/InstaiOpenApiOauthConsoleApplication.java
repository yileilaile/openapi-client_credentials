package com.instai.open.oauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableEurekaClient
@PropertySource(value = { "classpath:instai.properties" })
@MapperScan("com.instai.open.oauth.mapper")
@Order(6)
public class InstaiOpenApiOauthConsoleApplication {

    public static void main(String[] args) {
        SpringApplication.run(InstaiOpenApiOauthConsoleApplication.class, args);
    }

}
