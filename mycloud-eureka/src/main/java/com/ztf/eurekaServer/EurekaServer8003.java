package com.ztf.eurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author zhoutengfei
 * @Date 2020/5/31 5:43 PM
 * @Verson 1.0
 * @Describtion
 **/
@SpringBootApplication
@EnableEurekaServer //开启Eureka服务端，接受其它微服务注册进来
public class EurekaServer8003 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer8003.class, args);
    }
}
