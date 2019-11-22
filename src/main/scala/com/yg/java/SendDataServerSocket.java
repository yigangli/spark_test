package com.yg.java;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SendDataServerSocket {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9999);
        Scanner sc = new Scanner(System.in);
        Socket s = ss.accept();
        System.out.println("success");

        PrintWriter pw = new PrintWriter(s.getOutputStream());
        while(true){
            String msg = sc.nextLine();
            pw.println(msg);
            pw.flush();
            System.out.println(msg+"send success");
        }


    }
}
