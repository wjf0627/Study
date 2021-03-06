package com.jinfeng.spark.thread;

/**
 * Project : Spark
 * Package : com.jinfeng.study.examples
 * Author : WangJinfeng
 * Date : 2017-09-13 18:16
 * Email : jinfeng.wang@yoyi.com.cn
 * Phone : 152-1062-7698
 */
class MyThreads implements Runnable {
    private int ticket = 5;

    public void run() {
        for (int i = 0; i < 10; i++) {
            if (ticket > 0) {
                System.out.println("ticket = " + ticket--);
            }
        }
    }
}

public class RunnableDemo {
    public static void main(String[] args) {
        MyThreads my = new MyThreads();
        new Thread(my).start();
        new Thread(my).start();
        new Thread(my).start();
    }
}