package com.ztf.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhoutengfei
 * @Date 2020/5/31 4:45 PM
 * @Verson 1.0
 * @Describtion
 **/
@Configuration
public class RestTemplateConfig {

//    @Bean
//    @LoadBalanced
//    RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

    public static void main(String[] args) {
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getForEntity("http://MYCLOUD-PROVIDER/user?name={1}", String.class, "orange");

//        RestTemplate restTemplate = new RestTemplate();
//        Map<String, String> params = new HashMap<>();
//        params.put("key", "orange");
//        restTemplate.getForEntity("http://MYCLOUD-PROVIDER/user?name={key}", String.class, params);
        RestTemplate restTemplate = new RestTemplate();
        UriComponents uriComponents = UriComponentsBuilder
                .fromUriString("http://MYCLOUD-PROVIDER/user?name={key}")
                .build()
                .expand("orange")
                .encode();
        URI uri = uriComponents.toUri();
        ResponseEntity<String> forEntity = restTemplate.getForEntity(uri, String.class);

    }
}

