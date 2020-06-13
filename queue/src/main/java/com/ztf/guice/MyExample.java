package com.ztf.guice;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

/**
 * @Author zhoutengfei
 * @Date 2020/6/13 11:23 PM
 * @Verson 1.0
 * @Describtion google guice 轻量级inject框架
 **/
@Singleton
public class MyExample {

    @Inject
    Orange orange;

    public void sayGood() {
        orange.sayHello();
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        MyExample instance = injector.getInstance(MyExample.class);
        instance.sayGood();
    }
}

@Singleton
class Orange {

    public void sayHello() {
        System.out.println("hello orange");
    }
}
