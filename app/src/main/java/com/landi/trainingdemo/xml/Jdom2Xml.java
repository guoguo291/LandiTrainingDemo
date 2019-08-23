package com.landi.trainingdemo.xml;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by guoj on 2019/6/9.
 */

public class Jdom2Xml {
    public static void main(String[] args){
        createXML();
    }

    private static void createXML() {
        //1.创建Document对象 传入一个根节点
        Element ele_class = new Element("class");
        Document document=new Document(ele_class);
        //2.创建子节点
        Element student=new Element("student");
        student.setAttribute("id","1");
        ele_class.addContent(student);
        Element name=new Element("name");
        name.addContent("李四光");
        student.addContent(name);
        //3.使用XMLOutputter生成xml
        Format format=Format.getCompactFormat();
        format.setIndent("");
        XMLOutputter outputter=new XMLOutputter(format);
        try {
            outputter.output(document,new FileOutputStream(new File("student_jdom.xml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
