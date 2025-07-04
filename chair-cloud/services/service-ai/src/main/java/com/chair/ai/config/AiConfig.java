package com.chair.ai.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import static java.util.concurrent.TimeUnit.SECONDS;

@Configuration
public class AiConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
//
//    @Bean
//    Retryer retryer() {
//        return new Retryer.Default(100, SECONDS.toMillis(1), 5);
//    }
}
