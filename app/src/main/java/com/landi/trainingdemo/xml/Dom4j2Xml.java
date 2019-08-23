package com.landi.trainingdemo.xml;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by guoj on 2019/6/9.
 */

public class Dom4j2Xml {
    public static void main(String[]args){
        createXml();
    }

    private static void createXml() {
        //1创建Document
        Document document= DocumentHelper.createDocument();
        //2添加根节点
        Element ele_class=document.addElement("class");
        //3.添加子节点
        Element student=ele_class.addElement("student");
        student.addAttribute("id","2");
        Element name=student.addElement("name");
        name.setText("李冰");
        //4.生成xml
        try {
            OutputFormat outputFormat=OutputFormat.createPrettyPrint();
            outputFormat.setEncoding("utf-8");
            XMLWriter writer=new XMLWriter(new FileOutputStream(new File("student_dom4j.xml")),outputFormat);
            writer.write(document);
            writer.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
