package com.ztf;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author zhoutengfei
 * @Date 2020/6/4 11:02 PM
 * @Verson 1.0
 * @Describtion
 **/
public class TestBlockingQueue {

    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(5);

        Producer producer = new Producer("producer-1", queue);

        Consumer consumer1 = new Consumer("consumer-1", queue);
        Consumer consumer2 = new Consumer("consumer-2", queue);

        producer.start();
        consumer1.start();
        consumer2.start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    static class Producer extends Thread {

        private String name;
        private LinkedBlockingQueue<Integer> queue;

        public Producer(String name, LinkedBlockingQueue<Integer> queue) {
            super(name);
            this.name = name;
            this.queue = queue;
        }

        @Override
        public void run() {
            int end = 30;
            int start = 0;
            while (start < end) {
                try {
                    queue.put(start);
                    System.out.println("[" + name + "] Producing value : +" + start);
                    start ++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer extends Thread {
        private String name;
        private LinkedBlockingQueue<Integer> queue;

        public Consumer(String name, LinkedBlockingQueue<Integer> queue) {
            super(name);
            this.name = name;
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Integer result = queue.take();
                    System.out.println("[" + name + "] Consumer value : -" + result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
