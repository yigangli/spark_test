package com.yg.scala

import scala.io.Source

object WordCount {
  def main(args: Array[String]): Unit = {
    val file = Source.fromFile("src/file/word.txt")
    file.getLines().flatMap(_.split(" ")).map((_,1)).toList.groupBy(_._1).map(elem=>(elem._1,elem._2.size)).toList.sortBy(_._2).foreach(println)
    val arr = Range(1,100)
    arr.foreach(print)
    (0 until 100)
    for(x <- 0 until 100){
      println(x*2)
    }
  }
}
