package com.ztf.provider.service;

import com.ztf.api.bean.Corp;
import com.ztf.provider.dao.CorpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhoutengfei
 * @Date 2020/5/31 4:18 PM
 * @Verson 1.0
 * @Describtion
 **/
@Service
public class CorpService {

    @Autowired
    CorpMapper corpMapper;

    public List<Corp> getAllCorps() {
        return corpMapper.getCorps();
    }

    public void addCorp(Corp corp) {
        corpMapper.addCorp(corp);
    }

    public Corp getCorp(String id) {
        return corpMapper.getCorp(id);
    }
}
