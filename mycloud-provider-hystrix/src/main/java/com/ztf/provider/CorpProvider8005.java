package com.ztf.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @Author zhoutengfei
 * @Date 2020/5/31 4:27 PM
 * @Verson 1.0
 * @Describtion
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class CorpProvider8005 {

    public static void main(String[] args) {
        SpringApplication.run(CorpProvider8005.class, args);
    }
}
