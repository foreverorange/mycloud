package com.ztf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author zhoutengfei
 * @Date 2020/6/3 10:16 PM
 * @Verson 1.0
 * @Describtion
 **/
@ConfigurationProperties(prefix = "local.orange")
@Data
public class MyProperties {

    private String id;
    private String name;
    private int age;

}
