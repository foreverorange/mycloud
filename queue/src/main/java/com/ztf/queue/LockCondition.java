package com.ztf.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author zhoutengfei
 * @Date 2020/6/5 11:25 PM
 * @Verson 1.0
 * @Describtion Lock中condition的await()/signal()方法
 **/
public class LockCondition {

    private static final int CAPACITY = 5;
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition fullCondition = lock.newCondition();
    private static final Condition emptyCondition = lock.newCondition();
    private static final Queue<Integer> queue = new LinkedList<>();

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

    private static void consume() {
        while (true) {
            if (lock.tryLock()) {
                try {
                    while (queue.isEmpty()) {
                        // 队列为空，释放锁，通知生产者去生产
                        System.out.println(Thread.currentThread().getName() + " 队列为空，等待生产");
                        emptyCondition.await();
                    }

                    Integer poll = queue.poll();
                    System.out.println(Thread.currentThread().getName() + " 消费了 " + poll);

                    //唤醒其他所有生产者、消费者
                    fullCondition.signalAll();
                    emptyCondition.signalAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (lock.isHeldByCurrentThread()) {
                        lock.unlock();
                    }
                }
            }

            // 线程睡眠，便于看效果
            try {
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void produce() {
        while (true) {
            int k = 0;
            if (lock.tryLock()) {
                try {
                    while (queue.size() == CAPACITY) {
                        // 队列满了，释放锁，通知消费者去消费
                        System.out.println(Thread.currentThread().getName() + " 队列满了，等待消费");
                        fullCondition.await();
                    }

                    System.out.println(Thread.currentThread().getName() + " 生产了" + k);
                    queue.offer(k++);

                    //唤醒其他所有生产者、消费者
                    emptyCondition.signalAll();
                    fullCondition.signalAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (lock.isHeldByCurrentThread()) {
                        lock.unlock();
                    }
                }
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
