package com.yg.sparkstreaming

import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.kafka.KafkaUtils
//import org.apache.spark.streaming.kafka010.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

object KafkaStreamDemo {
  def main(args: Array[String]): Unit = {
    val ssc = new StreamingContext(new SparkConf(),Seconds(5))
    val kafkaParams :Map[String,String] = Map("group.id"->"1",""->"")
    val readParallelism = 5
    val topics = Map(""->1)
    val kafkaDStreams = (1 to readParallelism).map{_ =>
      //KafkaUtils.createDirectStream[String,String](ssc,_,_)
      KafkaUtils.createStream(ssc,kafkaParams,topics,StorageLevel.MEMORY_ONLY)
    }
    val unionDStream = ssc.union(kafkaDStreams)
  }
}
