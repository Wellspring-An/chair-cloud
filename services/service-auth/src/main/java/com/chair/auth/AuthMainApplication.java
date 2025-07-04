package com.chair.auth;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.listener.Listener;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.*;

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class AuthMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthMainApplication.class, args);
    }


    // 1.项目启动就监听配置文件的变化
    // 2.监听到变化，就自动更新到Spring容器中
    // 3.自动更新到Spring容器中，就可以直接使用
    // 4.监听配置文件的变化，发送邮件给管理员

    @Bean
    ApplicationRunner applicationRunner(NacosConfigManager nacosConfigManager) {
        return args ->
                nacosConfigManager.getConfigService().addListener("service-auth.yml", "DEFAULT_GROUP", new Listener() {
                            @Override
                            public Executor getExecutor() {
                                return new ThreadPoolExecutor(4, 4, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(20), new ThreadPoolExecutor.AbortPolicy());
                            }

                            @Override
                            public void receiveConfigInfo(String s) {
                                System.out.println("监听到配置文件变化，更新到Spring容器中：" + s);
                                System.out.println("发送邮件...");
                            }
                        }

                );
    }
}
