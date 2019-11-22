package com.yg.scala

import java.io.PrintWriter
import java.net.ServerSocket
import java.util.Scanner

object SendDateFromSocket {
  def main(args: Array[String]): Unit = {
    val ss = new ServerSocket(9999);
    val sc = new Scanner(System.in)
    val so = ss.accept
    print("connect success")
    val pw = new PrintWriter(so.getOutputStream)
    while(true){
      val msg = sc.nextLine()
      pw.println(msg)
      pw.flush()
      println("send success")
    }

  }
}
