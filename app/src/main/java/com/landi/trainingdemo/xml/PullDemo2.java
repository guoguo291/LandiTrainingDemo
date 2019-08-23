package com.landi.trainingdemo.xml;


import android.content.Context;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.IOException;


/**
 * Created by guoj on 2019/8/16.
 */

public class PullDemo2 {

    public static void parseXmlByPull(Context context) {
        try {
            XmlPullParserFactory factory=XmlPullParserFactory.newInstance();
            XmlPullParser parser=factory.newPullParser();
            parser.setInput(context.getAssets().open("students.xml"),"utf-8");
            int eventType=parser.getEventType();
            String id="";
            String name="";
            String sex="";
            while(eventType!=XmlPullParser.END_DOCUMENT){
                String nodeName=parser.getName();
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        if("student".equals(nodeName)){
                            id=parser.getAttributeValue(0);
                        }
                        if("name".equals(nodeName)){
                            name=parser.nextText();
                        }
                        if("sex".equals(nodeName)){
                            sex=parser.nextText();
                        }
                        break;
                    case  XmlPullParser.END_TAG:
                        if ("student".equals(nodeName)){
                            Log.i("pullpaser", "id："+id+"  name:"+name+"  sex"+sex);
                        }
                        break;
                    default:
                        break;
                }
                eventType=parser.next();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }
}
