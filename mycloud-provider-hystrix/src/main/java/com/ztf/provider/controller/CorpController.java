package com.ztf.provider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ztf.api.bean.Corp;
import com.ztf.provider.service.CorpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author zhoutengfei
 * @Date 2020/5/31 4:24 PM
 * @Verson 1.0
 * @Describtion
 **/
@RestController
public class CorpController {

    @Autowired
    CorpService corpService;

    @GetMapping("/corps")
    List<Corp> getAllCorps() {
        return corpService.getAllCorps();
    }

    @GetMapping("/corps/{id}")
    @HystrixCommand(fallbackMethod = "hystrixCorp")
    Corp getCorp(@PathVariable("id") String id) {
        Corp corp = corpService.getCorp(id);
        if (corp == null) {
            throw new RuntimeException("id " + id + " 不存在");
        }
        return corp;
    }

    Corp hystrixCorp(@PathVariable("id") String id) {
        return Corp.builder().id(id).name("hystrix").age(30).build();
    }
}
