package com.ztf.assist;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author zhoutengfei
 * @Date 2020/6/7 5:05 PM
 * @Verson 1.0
 * @Describtion 线程等待，加法计数器
 **/
public class MyCyclicBarrier {

    public static void main(String[] args) {
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        // 线程都ready后，会先执行该 barrierAction ，再执行各子线程的下一步任务
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, ()-> System.out.println("all is ready"));

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" is ready");
//                int numberWaiting = cyclicBarrier.getNumberWaiting();
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" is going");
            }, "线程"+i).start();
        }

        System.out.println("this is main");
    }
}
