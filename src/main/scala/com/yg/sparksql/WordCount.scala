package com.yg.sparksql

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql._

object WordCount {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local").setAppName(this.getClass.getSimpleName)
    val sc: SparkContext = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    val rdd1: RDD[String] = sc.textFile("src/file/word.txt")
    val wordcounts = rdd1.flatMap(_.split("\\s+")).map((_,1)).reduceByKey(_+_)
    wordcounts.foreach(println)
  }
}
