package com.ztf.consumer.service;

import com.ztf.api.bean.Corp;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhoutengfei
 * @Date 2020/5/31 11:31 PM
 * @Verson 1.0
 * @Describtion
 **/
@Service
public class HystrixConsumerService implements CorpConsumerService {
    public Corp getCorp(String id) {
        return Corp.builder().id(id).name("HystrixConsumerService").age(40).build();
    }

    public List<Corp> getCorps() {
        return null;
    }
}
