package com.landi.trainingdemo.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.Buffer;

/**
 * Created by guoj on 2019/6/1.
 */

public class SocketClient {
    public static void main(String[] args) {
        try {
            //1.创建Socket,指定ip和端口
            InetAddress inetAddress=InetAddress.getLocalHost();
            Socket socket = new Socket("0.0.0.0", 4002);
            //2.获取输出流 向服务端发送数据
            OutputStream os = socket.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os));
            bufferedWriter.write("我是客户端，你好啊"+"\n");
            bufferedWriter.flush();
            //写完数据后关闭socket输出流，这样服务端的输入流上的read操作就会返回-1 ，readLine返回null
           /* 不能调用shutdownInput。这样会导致socket被关闭。
            当然如果不需要继续在socket上进行读操作，也可以直接关闭socket。但是此方法不能用于通信双方需要多次交互的情况。*/
            /*需要多次通讯的话，发送数据时，约定数据的首部固定长度。这样读取到这个长度的数据后，就不继续调用read方法。*/
            socket.shutdownOutput();
            //读取服务端返回数据
            InputStream inputStream=  socket.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String readStr=null;
            while ((readStr=bufferedReader.readLine())!=null){
                System.out.println(readStr);
            }

            //关闭相关资源
            socket.shutdownInput();
            bufferedWriter.close();
            inputStream.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
