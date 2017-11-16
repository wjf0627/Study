package com.jinfeng.spark.example

import java.util.concurrent.{ExecutorService, Executors}

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by WangJinfeng on 2017/4/19.
  */
object PairRDD {

  def main(args: Array[String]): Unit = {
    val threadPool: ExecutorService = Executors.newFixedThreadPool(1)
    try {
      //提交5个线程
      for (i <- 1 to 5) {
        threadPool.submit(new ThreadDemo("thread" + i))
        //threadPool.execute(new ThreadDemo("thread" + i))
      }
    } finally {
      threadPool.shutdown()
    }
  }
}

class ThreadDemo(threadDemo: String) extends Runnable {

  @Override
  def run() {
    val conf = new SparkConf().setAppName(threadDemo).setMaster("local")
    conf.set("spark.driver.allowMultipleContexts", "true")
    println("AppName === " + threadDemo)
    val sc = new SparkContext(conf)
    val rdd = sc.parallelize(List((1, 2), (3, 4), (3, 6)))
    rdd.foreach(println)
    sc.stop()
  }
}