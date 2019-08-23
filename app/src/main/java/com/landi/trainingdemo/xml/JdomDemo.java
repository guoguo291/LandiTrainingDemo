package com.landi.trainingdemo.xml;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by guoj on 2019/6/4.
 */

public class JdomDemo {
    public static void main(String[] args){
        parseXmlByJdom();
    }

    private static void parseXmlByJdom() {
        SAXBuilder saxBuilder = new SAXBuilder();
        try {
            //构建文档对象
            Document document = saxBuilder.build(new File("students.xml"));
            //获取根节点
            Element rootElement = document.getRootElement();
            //获取根节点下的所有子节点
            List<Element> students = rootElement.getChildren();
            for (Element student:students) {
                System.out.println("解析第"+(students.indexOf(student)+1)+"个学生");
                List<Attribute>attributes=student.getAttributes();
//                System.out.println("ID:"+student.getAttributeValue("id"));
                for (Attribute attr:attributes) {
                    String attrName=attr.getName();
                    String attrValue=attr.getValue();
                    System.out.println(attrName+":"+attrValue);
                }
                //获取所有student的子节点
                List<Element>studentChildrens=student.getChildren();
                for (Element child:studentChildrens) {
                    String name=child.getName();
                    String value=child.getValue();
                    System.out.println(name+":"+value);
                }
            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
