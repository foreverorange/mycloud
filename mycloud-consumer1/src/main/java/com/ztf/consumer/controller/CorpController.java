package com.ztf.consumer.controller;

import com.ztf.api.bean.Corp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author zhoutengfei
 * @Date 2020/6/14 10:51 AM
 * @Verson 1.0
 * @Describtion
 **/
public class CorpController {

    @Autowired
    RestTemplate restTemplate;

    private String service = "http://MYCLOUD-PROVIDER";

    @GetMapping("/consumer/corps/{id}")
    Corp getCorp(@PathVariable("id") String id) {
        String url = service + "/corps/" + id;
        return restTemplate.getForObject(url, Corp.class);
    }

    @GetMapping("/consumer/corps")
    List<Corp> getCorps() {
        String url = service + "/corps/";
        return restTemplate.getForObject(url, List.class);
    }
}
