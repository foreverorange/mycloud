package com.ztf.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author zhoutengfei
 * @Date 2020/6/1 8:38 AM
 * @Verson 1.0
 * @Describtion
 * 通过 http://localhost:8006/mycloud-provider/corps 即可进行后台项目访问
 * 配置router后 http://localhost:8006/myprovider/corps
 **/
@SpringBootApplication
@EnableZuulProxy
public class MyZuul8006 {

    public static void main(String[] args) {
        SpringApplication.run(MyZuul8006.class, args);
    }
}
