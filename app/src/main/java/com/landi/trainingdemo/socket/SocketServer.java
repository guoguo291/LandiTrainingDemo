package com.landi.trainingdemo.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by guoj on 2019/6/1.
 */

public class SocketServer {
    public static void main(String[] args) {
        //1.创建服务端ServerSocket  指定监听的端口
        try {
            ServerSocket serverSocket = new ServerSocket(4002);
//            System.out.print( serverSocket.getInetAddress().getHostName());
            System.out.print(serverSocket.getInetAddress().getHostAddress());
            //2.调用 accept()开始监听,等待客户端消息
            Socket socket = serverSocket.accept();

            //3.获取socket的输入流获得客户端的消息
            InputStream inputStream = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream)) ;
            String str = null;
            while ((str=br.readLine())!= null) {
                System.out.println("服务端收到消息：" + str);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("我是服务端，你的消息收到了哈哈");
            bufferedWriter.flush();
            socket.shutdownOutput();

            //4.关闭相关资源
            socket.shutdownInput();
            inputStream.close();
            br.close();
            bufferedWriter.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
