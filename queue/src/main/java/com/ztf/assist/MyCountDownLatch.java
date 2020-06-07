package com.ztf.assist;

import java.util.concurrent.CountDownLatch;

/**
 * @Author zhoutengfei
 * @Date 2020/6/7 3:52 PM
 * @Verson 1.0
 * @Describtion 线程等待。减法计数器
 **/
public class MyCountDownLatch {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        // 线程a在执行后，经过await进行阻塞，当其他线程将countDownLatch减为0后，a继续执行
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "开始执行");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行完成");
        }, "a").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "开始执行");
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + "执行完成");
        }, "b").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "开始执行");
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName() + "执行完成");
        }, "c").start();

    }
}
