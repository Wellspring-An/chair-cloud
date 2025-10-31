package com.chair.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication(scanBasePackages = "com.chair")
@MapperScan("com.chair.app.mapper")
@EnableDiscoveryClient
public class ChairAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChairAppApplication.class, args);
    }

}
