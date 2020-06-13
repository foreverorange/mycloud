package com.ztf.guice;

import com.google.inject.*;

/**
 * @Author zhoutengfei
 * @Date 2020/6/13 11:39 PM
 * @Verson 1.0
 * @Describtion 通过继承AbstractModule进行注入
 * 定义装配规则，将类名绑定后置。使用@ImplementedBy注解需要知道具体的类名
 **/
public class MyExample2 {
    @Inject
    Apple apple;

    public void sayNice2() {
        apple.sayHello();
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new MyExampleModule());
        MyExample2 instance = injector.getInstance(MyExample2.class);
        instance.sayNice2();
    }
}

// 使用Module进行实例绑定
class MyExampleModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Apple2.class).to(SmallApple2.class);
        super.configure();
    }
}

interface Apple2 {
    void sayHello();
}

// 如果不用Singleton标注，每次获取实例时，Guice会重新构造一个，
// 这个会有反射构造器的性能损耗，在高性能场景下，请谨慎。
@Singleton
class BigApple2 implements Apple2 {
    @Override
    public void sayHello() {
        System.out.println("hello big apple");
    }
}

@Singleton
class SmallApple2 implements Apple2 {
    @Override
    public void sayHello() {
        System.out.println("hello small apple");
    }
}

