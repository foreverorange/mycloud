package com.ztf.consumer.controller;

import com.ztf.api.bean.Corp;
import com.ztf.consumer.service.CorpConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author zhoutengfei
 * @Date 2020/5/31 4:47 PM
 * @Verson 1.0
 * @Describtion
 **/
@RestController
public class CorpConsumerController {

//    @Autowired
//    RestTemplate restTemplate;

    // 第一版是通过固定url直接访问
//    private String service = "http://localhost:8001";
    // 第二版根据服务名去访问，需要将restTemplate注解为@LoadBalanced才会生效
//    private String service = "http://MYCLOUD-PROVIDER";
    // 第三版使用feign去调用
    @Autowired
    CorpConsumerService corpConsumerService;

    @RequestMapping("/consumer/corps/{id}")
    Corp getCorp(@PathVariable("id") String id) {
        return corpConsumerService.getCorp(id);
    }

    @RequestMapping("/consumer/corps")
    List<Corp> getCorps() {
        return corpConsumerService.getCorps();
    }

//    @RequestMapping("/consumer/corps/{id}")
//    Corp getCorp(@PathVariable("id") String id) {
//        String url = service + "/corps/";
//        return restTemplate.getForObject(url + id, Corp.class);
//    }
//
//    @RequestMapping("/consumer/corps")
//    List<Corp> getCorps() {
//        String url = service + "/corps/";
//        return restTemplate.getForObject(url, List.class);
//    }
}
