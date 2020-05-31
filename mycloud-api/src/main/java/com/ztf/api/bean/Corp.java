package com.ztf.api.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author zhoutengfei
 * @Date 2020/5/31 3:47 PM
 * @Verson 1.0
 * @Describtion
 **/
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class Corp implements Serializable {

    private String id;
    private String name;
    private int age;
}
