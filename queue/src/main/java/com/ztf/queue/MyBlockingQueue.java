package com.ztf.queue;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author zhoutengfei
 * @Date 2020/6/6 4:55 PM
 * @Verson 1.0
 * @Describtion linkedBlockingQueue方式的生产者消费者
 **/
public class MyBlockingQueue {

    private static final int CAPICITY = 3;
    private static final int MAX = 30;
    private static final LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(CAPICITY);

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> produce(), "product-" + i).start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(() -> consume(), "consumer-" + i).start();
        }

        // 主线程睡眠，便于看效果
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }

    static void produce() {
        int k = 0;
        while (k < MAX) {
            try {
                System.out.println(Thread.currentThread().getName() + " 生产了" + k);
                queue.put(k++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 线程睡眠，便于看效果
            try {
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void consume() {
        while (true) {
            try {
                Integer take = queue.take();
                System.out.println(Thread.currentThread().getName() + "消费了" + take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 线程睡眠，便于看效果
            try {
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
