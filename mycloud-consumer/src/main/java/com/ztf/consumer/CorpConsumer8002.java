package com.ztf.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author zhoutengfei
 * @Date 2020/5/31 4:55 PM
 * @Verson 1.0
 * @Describtion
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CorpConsumer8002 {

    public static void main(String[] args) {
        SpringApplication.run(CorpConsumer8002.class, args);
    }
}
