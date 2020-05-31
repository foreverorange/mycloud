package com.ztf.provider.dao;

import com.ztf.api.bean.Corp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhoutengfei
 * @Date 2020/5/31 4:06 PM
 * @Verson 1.0
 * @Describtion
 **/
@Mapper
@Repository
public interface CorpMapper {
    List<Corp> getCorps();

    void addCorp(Corp corp);

    Corp getCorp(String id);
}
