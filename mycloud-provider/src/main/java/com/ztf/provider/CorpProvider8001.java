package com.ztf.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author zhoutengfei
 * @Date 2020/5/31 4:27 PM
 * @Verson 1.0
 * @Describtion
 **/
@SpringBootApplication
@EnableEurekaClient
public class CorpProvider8001 {

    public static void main(String[] args) {
        SpringApplication.run(CorpProvider8001.class, args);
    }
}
