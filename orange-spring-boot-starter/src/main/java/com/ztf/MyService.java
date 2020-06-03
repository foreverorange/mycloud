package com.ztf;

/**
 * @Author zhoutengfei
 * @Date 2020/6/3 10:18 PM
 * @Verson 1.0
 * @Describtion
 **/
public class MyService {

    MyProperties myProperties;

    public void setMyProperties(MyProperties myProperties) {
        this.myProperties = myProperties;
    }

    public MyService(MyProperties myProperties) {
        this.myProperties = myProperties;
    }

    public void helloWorld() {
        System.out.println("hi, 我叫: " + myProperties.getName() +
                ", id:" + myProperties.getId() + "岁"
                + ", 年龄: " + myProperties.getAge());
    }
}
