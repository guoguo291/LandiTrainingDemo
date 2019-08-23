package com.landi.trainingdemo.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Created by guoj on 2019/6/4.
 */

public class Dom4jDemo {
    public static void main(String[] args) {
        parseXmlByDom4j();
    }

    private static void parseXmlByDom4j() {
        //获取一个SAXReader对象
        SAXReader saxReader = new SAXReader();
        try {
            //读取xml文件获取
            Document document = saxReader.read(new File("students.xml"));
            //获取根节点
            Element rootElement = document.getRootElement();
            //通过获取根节点的迭代器  遍历所有子节点
            Iterator it = rootElement.elementIterator();
            while (it.hasNext()) {
                System.out.println("------------------------");
                //获取子节点
                Element element = (Element) it.next();
                //获取所有子节点的属性
                List<Attribute> attributes = element.attributes();
                for (Attribute attr : attributes) {
                    System.out.println(attr.getName()+":"+attr.getValue());
                }
                Iterator studentIt=element.elementIterator();
                while (studentIt.hasNext()){
                    //获取子节点
                    Element stuChild = (Element) studentIt.next();
                    System.out.println( stuChild.getName()+":"+stuChild.getStringValue());
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
