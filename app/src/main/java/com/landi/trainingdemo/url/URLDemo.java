package com.landi.trainingdemo.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by guoj on 2019/5/28.
 */

public class URLDemo {
    public static void main(String[] args){
        try
        {
            URL url = new URL("http://www.baidu.com");
            URLConnection urlConnection = url.openConnection();
            System.out.println(urlConnection.getContentType());
            HttpURLConnection connection = null;
            if(urlConnection instanceof HttpURLConnection)
            {
                connection = (HttpURLConnection) urlConnection;
            }
            else
            {
                System.out.println("请输入 URL 地址");
                return;
            }
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String urlString = "";
            String current;
            while((current = in.readLine()) != null)
            {
//                urlString += current;
                System.out.println(current);
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
