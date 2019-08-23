package com.landi.trainingdemo.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.DatagramSocketImplFactory;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by guoj on 2019/6/1.
 */

public class UDPClient {
    public static void main(String[]args){
        try {
            //1.指定服务器的ip和端口
            InetAddress address=InetAddress.getLocalHost();
            //2.创建发送的数据
            byte[] data="你好，我是客户端！".getBytes();
            //3.创建数据报
            DatagramPacket packet=new DatagramPacket(data,data.length,address,3003);
            //4.创建DatagramSocket
            DatagramSocket socket=new DatagramSocket();
            socket.send(packet);

            //接受服务端返回数据
            byte[] respData=new byte[1024];
            DatagramPacket packet1=new DatagramPacket(respData,respData.length);
            socket.receive(packet1);
            String receiveInfo=new String(respData,0,respData.length);
            System.out.println("客户端收到返回："+receiveInfo);

            //关闭资源
            socket.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
