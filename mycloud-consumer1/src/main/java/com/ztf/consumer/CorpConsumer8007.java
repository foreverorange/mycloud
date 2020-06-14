package com.ztf.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author zhoutengfei
 * @Date 2020/5/31 4:55 PM
 * @Verson 1.0
 * @Describtion
 **/
@SpringBootApplication
public class CorpConsumer8007 {

    public static void main(String[] args) {
        SpringApplication.run(CorpConsumer8007.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
