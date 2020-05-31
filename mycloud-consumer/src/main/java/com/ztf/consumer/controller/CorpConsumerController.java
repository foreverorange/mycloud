package com.ztf.consumer.controller;

import com.ztf.api.bean.Corp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
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

    @Autowired
    RestTemplate restTemplate;

    private String url = "http://localhost:8001/corps/";

    @RequestMapping("/consumer/corps/{id}")
    Corp getCorp(@PathVariable("id") String id) {
        return restTemplate.getForObject(url + id, Corp.class);
    }

    @RequestMapping("/consumer/corps")
    List<Corp> getCorps() {
        return restTemplate.getForObject(url, List.class);
    }
}
