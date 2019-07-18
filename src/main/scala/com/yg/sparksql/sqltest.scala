package com.yg.sparksql

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql._

object sqltest {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local").setAppName(this.getClass.getSimpleName)
    val sc: SparkContext = new SparkContext(conf)
    sc.setLogLevel("OFF")
    val rdd1: RDD[String] = sc.textFile("E:\\workspace\\testspark\\src\\file\\word.txt")
    rdd1.foreach(println)
  }
}
