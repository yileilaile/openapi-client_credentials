package com.instai.open.eurake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@EnableEurekaServer
@PropertySource(value = {"classpath:instai.properties"})
public class InstaiOpenEurakaApplication {

    public static void main(String[] args) {
        SpringApplication.run(InstaiOpenEurakaApplication.class, args);
    }

}
