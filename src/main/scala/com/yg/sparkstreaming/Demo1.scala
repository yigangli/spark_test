package com.yg.sparkstreaming

import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}

object Demo1 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("test").setMaster("local[2]")
    val ssc = new StreamingContext(conf,Seconds(5))
    ssc.checkpoint(".")

    val socketds: ReceiverInputDStream[String] = ssc.socketTextStream("liyigang.sjzx.intra", 9999)
    val words: DStream[(String, Int)]  = socketds.flatMap(_.split("\\s+")).map((_,1))
    val wordCounts = words.updateStateByKey((values:Seq[Int], status:Option[Int]) => {
      val currentCount = values.sum
      val cnt = status.getOrElse(0)
      Some(currentCount+cnt)
    })
    wordCounts.print
    ssc.start()
    ssc.awaitTermination()
  }
}
