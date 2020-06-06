package com.ztf;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * @Author zhoutengfei
 * @Date 2020/6/5 10:12 PM
 * @Verson 1.0
 * @Describtion 使用object的wait、notify方法
 **/
public class ProducerConsumer {

    private static final int CAPACITY = 5;
    private static final Queue<Integer> queue = new LinkedList<Integer>();

    public static void main(String[] args) {

        // 模拟生产者
        for (int i = 0; i < 3; i++) {
            new Thread(()-> produce(),"procuder-"+ i).start();
        }

        // 模拟消费者
        for (int i = 0; i < 5; i++) {
            new Thread(()-> consume(),"consumer-"+ i).start();
        }

        // 主线程睡眠，便于看效果
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }

    private static void consume() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        // 空队列，则不能消费
                        System.out.println(Thread.currentThread().getName() + " 等待生产");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 队列不为空，则正常消费
                Integer poll = queue.poll();
                System.out.println(Thread.currentThread().getName() + " 消费了" + poll);
                queue.notifyAll();
                // 线程睡眠，便于看效果
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void produce() {
        int k = 0;
        while (true) {
            synchronized (queue) {
                while (queue.size() == CAPACITY) {
                    try {
                        // 满了则wait
                        System.out.println(Thread.currentThread().getName() + " 等待消费");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 没满则往queue中添加元素
                System.out.println(Thread.currentThread().getName() + " 生产了" + k);
                queue.offer(k++);

                queue.notifyAll();

                // 线程睡眠，便于看效果
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
