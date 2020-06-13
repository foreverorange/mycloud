package com.ztf.guice;

import com.google.inject.*;

/**
 * @Author zhoutengfei
 * @Date 2020/6/13 11:27 PM
 * @Verson 1.0
 * @Describtion
 * Guice里最常用的两个注解就是@Singleton和@Inject，
 * Singleton表示构建的对象是单例的，
 * Inject表示被标注的字段将使用Guice自动注入
 **/
public class MyExample1 {
    @Inject
    Apple apple;

    public void sayNice() {
        apple.sayHello();
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        MyExample1 instance = injector.getInstance(MyExample1.class);
        instance.sayNice();
    }

}

// 当某个接口有多个实现时，我们使用@ImplementedBy注解在接口定义上，指定接口的具体实现类
@ImplementedBy(SmallApple.class)
interface Apple {
    void sayHello();
}

// 如果不用Singleton标注，每次获取实例时，Guice会重新构造一个，
// 这个会有反射构造器的性能损耗，在高性能场景下，请谨慎。
@Singleton
class BigApple implements Apple {
    @Override
    public void sayHello() {
        System.out.println("hello big apple");
    }
}

@Singleton
class SmallApple implements Apple {
    @Override
    public void sayHello() {
        System.out.println("hello small apple");
    }
}


