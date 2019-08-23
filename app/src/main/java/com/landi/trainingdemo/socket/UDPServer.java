package com.landi.trainingdemo.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.DatagramSocketImplFactory;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by guoj on 2019/6/1.
 */

public class UDPServer {
    public static void main(String[]args){
        //1.创建服务端套接字DatagramSocket，指定端口
        try {
            DatagramSocket socket=new DatagramSocket(3003);
//            socket.getInetAddress().getHostName();
            //2.创建数据报DatagramPacket
            byte[] data=new byte[1024];
            DatagramPacket packet=new DatagramPacket(data,data.length);
            //3.接受客户端返回
            socket.receive(packet);
            //4.读取客户端数据
            String msg=new String(data,0,data.length);
            System.out.println("服务端收到消息："+msg);
            /*
            * 服务端返回消息给客户端
            * */
            InetAddress clientaddress=packet.getAddress();
            int port=packet.getPort();
            byte[] respData="我是服务端，你的消息收到了！".getBytes();
            DatagramPacket packet2=new DatagramPacket(respData,respData.length,clientaddress,port);
            DatagramSocket socket2=new DatagramSocket();
            socket2.send(packet2);
            //关闭资源
            socket.close();
            socket2.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
