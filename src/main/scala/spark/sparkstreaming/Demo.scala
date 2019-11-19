package spark.sparkstreaming

import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Demo {
  def main(args: Array[String]): Unit = {
    import org.apache.spark.SparkConf
    val conf = new SparkConf().setAppName("test").setMaster("local[2]")
    val ssc = new StreamingContext(conf,Seconds(5))
    val socketds: ReceiverInputDStream[String] = ssc.socketTextStream("liyigang.sjzx.intra", 9999)
    val wordCounts = socketds.flatMap(_.split("\\s+")).map((_,1)).reduceByKey(_+_)
//    val textds = ssc.textFileStream("src/file/")
//    val wordCounts = textds.flatMap(_.split("\\s+")).map((_,1)).reduceByKey(_+_)
    wordCounts.print
    ssc.start()
    ssc.awaitTermination()
  }
}
