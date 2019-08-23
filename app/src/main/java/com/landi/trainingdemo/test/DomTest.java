package com.landi.trainingdemo.test;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by guoj on 2019/7/12.
 */

public class DomTest {
    public static void main(String []args){
        //1..创建工厂类对象 DocumentBuilderFactory
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        //2.通过工厂类对象创建一个构建者对象
        try {
            DocumentBuilder builder=factory.newDocumentBuilder();
            File file=new File("students.xml");
            Document document=builder.parse(file);
            NodeList students=document.getElementsByTagName("student");
            for (int i = 0; i < students.getLength(); i++) {
                Node student=students.item(i);
                NamedNodeMap namedNodeMap=student.getAttributes();
                for (int j = 0; j < namedNodeMap.getLength(); j++) {
                    Node node1=namedNodeMap.item(j);
                    String id=node1.getTextContent();
                    System.out.println(node1.getNodeName()+":"+id);
                }
                System.out.println(student.getNodeName());

            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
