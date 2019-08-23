package com.landi.trainingdemo.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by guoj on 2019/6/2.
 */

public class DomDemo {
    public static void main(String[] args){
        parseXmlByDom();
    }

    private static void parseXmlByDom() {

        //创建工厂类
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        try {
            //创建一个构建者类
            DocumentBuilder builder=factory.newDocumentBuilder();
            //创建一个Dcument对象
            Document document=builder.parse(new File("students.xml"));
            //获取节点集合  节点类型有三种   element   attr   text
            NodeList students=document.getElementsByTagName("student");
            System.out.println("有学生"+students.getLength()+"人");
            for (int i = 0; i <students.getLength() ; i++) {
                System.out.println("第"+(i+1)+"名学生的信息");
                Node student=students.item(i);
//                获取所有节点的属性
                NamedNodeMap namedNodeMap=student.getAttributes();
                for (int j = 0; j <namedNodeMap.getLength() ; j++) {
                    Node attr=namedNodeMap.item(j);
                    String attrName=attr.getNodeName();
                    String attrNodeValue=attr.getNodeValue();
                    System.out.println("属性名："+attrName+",属性值:"+attrNodeValue);
                }
                //获取student的子节点
                NodeList childNodes=student.getChildNodes();
                //遍历所有子节点获取子节点的节点名和节点值
                System.out.println("第"+(i+1)+"名学生的子节点个数："+childNodes.getLength());
                for (int a = 0; a <childNodes.getLength() ; a++) {
                    Node node=childNodes.item(a);
//                    System.out.println("子节点名："+node.getNodeName()+",子节点值:"+node.getNodeValue());
                    //去掉无效的节点和节点值#text对应的值
                    if(node.getNodeType()==Node.ELEMENT_NODE){
                        //子节点值为NULL   因为Element类型的节点是没有节点值的
//                        System.out.println("子节点名："+node.getNodeName()+",子节点值:"+node.getNodeValue());
//                        System.out.println("子节点名："+node.getNodeName()+",子节点值:"+node.getFirstChild().getNodeValue());
                        //getTextContent()获取所有子节点的值
                        System.out.println("子节点名："+node.getNodeName()+",子节点值:"+node.getTextContent());
                    }
                }
//                Element element= (Element) students.item(i);
//                System.out.println("属性名：id"+",属性值:"+element.getAttribute("id"));

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
