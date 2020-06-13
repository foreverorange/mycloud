package com.ztf.guice;

import com.google.inject.*;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

/**
 * @Author zhoutengfei
 * @Date 2020/6/14 12:05 AM
 * @Verson 1.0
 * @Describtion named 构造器注入
 **/
public class MyExample4 {

    Apple4 smallApple;
    Apple4 bigApple;

    @Inject
    public MyExample4(@Named("small") Apple4 smallApple, @Named("big") Apple4 bigApple) {
        this.smallApple = smallApple;
        this.bigApple = bigApple;
    }

    public void sayNice4() {
        smallApple.sayHello4();
        bigApple.sayHello4();
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new MyExampleModule4());
        MyExample4 instance = injector.getInstance(MyExample4.class);
        instance.sayNice4();
    }
}

// 使用Module进行实例绑定
class MyExampleModule4 extends AbstractModule {
    @Override
    protected void configure() {
        bind(Apple4.class).annotatedWith(Names.named("small")).to(SmallApple4.class);
        bind(Apple4.class).annotatedWith(Names.named("big")).to(BigApple4.class);
    }
}

interface Apple4 {
    void sayHello4();
}

// 如果不用Singleton标注，每次获取实例时，Guice会重新构造一个，
// 这个会有反射构造器的性能损耗，在高性能场景下，请谨慎。
@Singleton
class BigApple4 implements Apple4 {
    @Override
    public void sayHello4() {
        System.out.println("hello big apple4");
    }
}

@Singleton
class SmallApple4 implements Apple4 {
    @Override
    public void sayHello4() {
        System.out.println("hello small apple4");
    }
}
