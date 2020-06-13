package com.ztf.guice;

import com.google.inject.*;
import com.google.inject.multibindings.MapBinder;

import java.util.Map;

/**
 * @Author zhoutengfei
 * @Date 2020/6/15 12:11 AM
 * @Verson 1.0
 * @Describtion map、set容器
 **/
public class MyExample5 {

//    @Inject
//    private Set<Apple5> apple5Set;

    @Inject
    private Map<String, Apple5> apple5Map;

    public void sayNice5() {
//        apple5Set.forEach(Apple5::sayHello5);
        apple5Map.forEach((key, value) -> {
            System.out.println("【key】：" + key);
            value.sayHello5();
        });
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new MyExampleModule5());
        MyExample5 instance = injector.getInstance(MyExample5.class);
        instance.sayNice5();
    }
}

// 使用Module进行实例绑定
class MyExampleModule5 extends AbstractModule {
    @Override
    protected void configure() {
//        Multibinder<Apple5> apple5Multibinder = Multibinder.newSetBinder(binder(), Apple5.class);
//        apple5Multibinder.addBinding().to(SmallApple5.class);
//        apple5Multibinder.addBinding().to(BigApple5.class);

        MapBinder<String, Apple5> apple5MapBinder = MapBinder.newMapBinder(binder(), String.class, Apple5.class);
        apple5MapBinder.addBinding("big").to(BigApple5.class);
        apple5MapBinder.addBinding("small").to(SmallApple5.class);
    }
}

interface Apple5 {
    void sayHello5();
}

// 如果不用Singleton标注，每次获取实例时，Guice会重新构造一个，
// 这个会有反射构造器的性能损耗，在高性能场景下，请谨慎。
@Singleton
class BigApple5 implements Apple5 {
    @Override
    public void sayHello5() {
        System.out.println("hello big apple5");
    }
}

@Singleton
class SmallApple5 implements Apple5 {
    @Override
    public void sayHello5() {
        System.out.println("hello small apple5");
    }
}
