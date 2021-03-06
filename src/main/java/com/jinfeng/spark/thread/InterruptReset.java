package com.jinfeng.spark.thread;

/**
 * Project : Spark
 * Package : com.jinfeng.study.examples
 * Author : WangJinfeng
 * Date : 2017-09-14 15:12
 * Email : jinfeng.wang@yoyi.com.cn
 * Phone : 152-1062-7698
 */
public class InterruptReset extends Object {
    public static void main(String[] args) {
        System.out.println("Point X : Thread.interrupted() = " + Thread.interrupted());
        Thread.currentThread().interrupt();
        System.out.println("Point Y : Thread.interrupted() = " + Thread.interrupted());
        System.out.println("Point Z : Thread.interrupted() = " + Thread.interrupted());
    }
}
