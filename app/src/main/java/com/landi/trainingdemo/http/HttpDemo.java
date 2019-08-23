package com.landi.trainingdemo.http;



import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by guoj on 2019/6/1.
 */

public class HttpDemo {
    public static void main(String[] args) {
//        doGet();
//        doPost();
        doHttpClientGet();
    }


    private static void doGet() {
        try {

            String url ="http://apis.juhe.cn/mobile/get?phone=18410402661&key=7444e1cc1db7a6679ca9c990228437b8";//请求接口地址

            URL httpurl=new URL(url);
            HttpURLConnection urlConnection= (HttpURLConnection) httpurl.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(5000);
            urlConnection.setDoInput(true);
            BufferedReader br=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String resp;
            StringBuffer stringBuffer=new StringBuffer();
            while ((resp=br.readLine())!=null){
                stringBuffer.append(resp);
            }
            System.out.println("收到返回："+stringBuffer.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void doPost() {
        try {

            String url ="http://apis.juhe.cn/mobile/get";//请求接口地址

            URL httpurl=new URL(url);
            HttpURLConnection urlConnection= (HttpURLConnection) httpurl.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setReadTimeout(5000);
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            OutputStream outputStream=urlConnection.getOutputStream();
            String request="phone=13663600236&key=7444e1cc1db7a6679ca9c990228437b8";
            outputStream.write(request.getBytes());
            BufferedReader br=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String resp;
            StringBuffer stringBuffer=new StringBuffer();
            while ((resp=br.readLine())!=null){
                stringBuffer.append(resp);
            }
            System.out.println("POST收到返回："+stringBuffer.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void doHttpClientGet() {
        try {

            String url ="http://apis.juhe.cn/mobile/get?phone=18410402661&key=7444e1cc1db7a6679ca9c990228437b8";//请求接口地址
            HttpGet httpGet=new HttpGet(url);
            HttpClient  client= new DefaultHttpClient();
            HttpResponse response=client.execute(httpGet);

            if (response!=null){
                System.out.print("StatusCode:"+response.getStatusLine().getStatusCode());
                String result=EntityUtils.toString(response.getEntity());
                Log.i("guoj", "收到返回数据："+result);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void doHttpClientPost() {
        try {

            String url ="http://apis.juhe.cn/mobile/get" ;
//                    "?phone=18410402661&key=7444e1cc1db7a6679ca9c990228437b8";//请求接口地址

//            URL httpurl=new URL(url);

            HttpPost httpPost=new HttpPost(url);
            ArrayList<NameValuePair> list=new ArrayList<NameValuePair>();
            list.add(new BasicNameValuePair("phone","18410402661"));
            list.add(new BasicNameValuePair("key","7444e1cc1db7a6679ca9c990228437b8"));
            HttpEntity entity=new UrlEncodedFormEntity(list);
            httpPost.setEntity(entity);
            HttpClient  client= new DefaultHttpClient();
            HttpResponse response=client.execute(httpPost);

            if (response!=null){
                System.out.print("StatusCode:"+response.getStatusLine().getStatusCode());
                String result=EntityUtils.toString(response.getEntity());
                Log.i("guoj", "HttpClient-Post收到返回数据："+result);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
