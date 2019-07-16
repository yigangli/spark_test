package com.yg.scala

import scala.collection.mutable.ArrayBuffer

object test {
  def main(args: Array[String]): Unit = {
    val arr = Array(1,-3,6,2,-2,0,7,5,-4)
    val newarr1 = new ArrayBuffer[Int]()
    val newarr2 = new ArrayBuffer[Int]()
    for (index<-arr.indices){
      if(arr(index)>0)
        newarr1+=arr(index)
      else
        newarr2+=arr(index)
    }
    newarr1.foreach(print)
    println
    newarr2.foreach(print)
  }
}
