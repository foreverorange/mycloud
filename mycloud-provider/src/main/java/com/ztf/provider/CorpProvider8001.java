package com.ztf.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author zhoutengfei
 * @Date 2020/5/31 4:27 PM
 * @Verson 1.0
 * @Describtion
 **/
@SpringBootApplication
// 可不加该配置，Dalston之后的版本中（不含Dalston），只要开启了springboot的自动配置，服务注册发现功能就会启用
// 使用配置项`spring.cloud.service-registry.auto-registration.enabled=false`即可禁止服务注册发现功能。
// eureka.client.register-with-eureka: false 也可禁止服务注册功能。
// @EnableEurekaClient
public class CorpProvider8001 {

    public static void main(String[] args) {
        SpringApplication.run(CorpProvider8001.class, args);
    }
}
