package com.ztf.consumer.service;

import com.ztf.api.bean.Corp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Author zhoutengfei
 * @Date 2020/5/31 10:26 PM
 * @Verson 1.0
 * @Describtion
 **/
@FeignClient(name = "MYCLOUD-PROVIDER", fallback = HystrixConsumerService.class)
public interface CorpConsumerService {

    @GetMapping("/corps/{id}")
    Corp getCorp(@PathVariable("id") String id);

    @GetMapping("/corps")
    List<Corp> getCorps();
}
