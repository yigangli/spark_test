package com.yg.sparksql

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql._

object sqltest {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local").setAppName(this.getClass.getSimpleName)
    val sc: SparkContext = new SparkContext(conf)
    val rdd1: RDD[String] = sc.textFile("C:\\Users\\LYG\\Desktop\\word.txt")
    rdd1.foreach(println)
  }
}
