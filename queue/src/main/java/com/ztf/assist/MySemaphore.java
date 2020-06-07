package com.ztf.assist;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author zhoutengfei
 * @Date 2020/6/7 5:56 PM
 * @Verson 1.0
 * @Describtion 信号量，一般可用于限流
 **/
public class MySemaphore {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"进行占位");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName()+"释放位置");
                }
            }, "thread-"+i).start();
        }

    }
}
