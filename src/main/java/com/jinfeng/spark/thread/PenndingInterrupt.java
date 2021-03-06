package com.jinfeng.spark.thread;

/**
 * Project : Spark
 * Package : com.jinfeng.study.examples
 * Author : WangJinfeng
 * Date : 2017-09-14 10:42
 * Email : jinfeng.wang@yoyi.com.cn
 * Phone : 152-1062-7698
 */
public class PenndingInterrupt {
    public static void main(String[] args) {
        args = new String[2];
        args[0] = "yes";
        args[1] = "no";
        // 如果输入了参数，则在main线程中中断当前线程（亦即main线程）
        if (args.length > 0) {
            Thread.currentThread().interrupt();
        }
        //  获取当前时间
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(2000);
            System.out.println("was Not interrupted");
        } catch (InterruptedException e) {
            System.out.println("was interrupted");
        }
        //  计算中间代码执行的时间
        System.out.println("elapsedTime = " + (System.currentTimeMillis() - startTime));
    }
}
