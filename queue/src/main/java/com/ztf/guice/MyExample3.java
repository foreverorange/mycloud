package com.ztf.guice;

import com.google.inject.*;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

/**
 * @Author zhoutengfei
 * @Date 2020/6/13 11:50 PM
 * @Verson 1.0
 * @Describtion name注入
 **/
public class MyExample3 {

    @Inject
    @Named("small")
    Apple3 smallApple;

    @Inject
    @Named("big")
    Apple3 bigApple;

    public void sayNice3() {
        smallApple.sayHello3();
        bigApple.sayHello3();
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new MyExampleModule3());
        MyExample3 instance = injector.getInstance(MyExample3.class);
        instance.sayNice3();
    }
}

// 使用Module进行实例绑定
class MyExampleModule3 extends AbstractModule {
    @Override
    protected void configure() {
        bind(Apple3.class).annotatedWith(Names.named("small")).to(SmallApple3.class);
        bind(Apple3.class).annotatedWith(Names.named("big")).to(BigApple3.class);
    }
}

interface Apple3 {
    void sayHello3();
}

// 如果不用Singleton标注，每次获取实例时，Guice会重新构造一个，
// 这个会有反射构造器的性能损耗，在高性能场景下，请谨慎。
@Singleton
class BigApple3 implements Apple3 {
    @Override
    public void sayHello3() {
        System.out.println("hello big apple");
    }
}

@Singleton
class SmallApple3 implements Apple3 {
    @Override
    public void sayHello3() {
        System.out.println("hello small apple");
    }
}
