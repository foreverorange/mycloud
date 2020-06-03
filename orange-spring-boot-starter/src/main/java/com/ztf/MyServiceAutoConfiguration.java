package com.ztf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhoutengfei
 * @Date 2020/6/3 10:22 PM
 * @Verson 1.0
 * @Describtion
 **/
@Configuration
@EnableConfigurationProperties(MyProperties.class)
@ConditionalOnClass(MyService.class)
@ConditionalOnProperty(prefix = "local.orange", value = "enabled", matchIfMissing = true)
public class MyServiceAutoConfiguration {

    @Autowired
    MyProperties myProperties;

    @Bean
    @ConditionalOnMissingBean(MyService.class)
    public MyService myService() {
        return new MyService(myProperties);
    }
}
