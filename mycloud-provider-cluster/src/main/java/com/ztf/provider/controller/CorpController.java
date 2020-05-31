package com.ztf.provider.controller;

import com.ztf.api.bean.Corp;
import com.ztf.provider.service.CorpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
    Corp getCorp(@PathVariable("id") String id) {
        return corpService.getCorp(id);
    }
}
