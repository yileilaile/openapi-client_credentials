package com.instai.open.baseinfo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.instai.open.baseinfo.mapper")	//mapper包扫描或者在 mapper接口上面 @mapper
@EnableTransactionManagement    //启注解事务管理
@EnableFeignClients
@PropertySource(value = { "classpath:instai.properties" })
public class InstaiOpenBaseinfoApplication {


    public static void main(String[] args) {
        SpringApplication.run(InstaiOpenBaseinfoApplication.class, args);
    }
}
