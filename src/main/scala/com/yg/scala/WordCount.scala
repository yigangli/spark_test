package com.yg.scala

import scala.io.Source

object WordCount {
  def main(args: Array[String]): Unit = {
    val file = Source.fromFile("E:\\workspace\\testspark\\src\\file\\word.txt")
    file.getLines().flatMap(_.split(" ")).map((_,1)).toList.groupBy(_._1).map(elem=>(elem._1,elem._2.size)).toList.sortBy(_._2).foreach(println)
  }
}
