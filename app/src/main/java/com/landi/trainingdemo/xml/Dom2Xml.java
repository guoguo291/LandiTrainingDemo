package com.landi.trainingdemo.xml;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * Created by guoj on 2019/6/9.
 */

public class Dom2Xml {
    public static void main(String[] args) {
        createXml();
    }

    private static void createXml() {
        //1 获取工厂类
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        try {
            //2 生成构建者
            DocumentBuilder builder=factory.newDocumentBuilder();
            //3 生成Document
            Document document=builder.newDocument();
            //4 生成根节点
            Element root_class=document.createElement("class");
            //5 生成子节点
            Element student=document.createElement("student");
            student.setAttribute("id","1");
            Element name=document.createElement("name");
            name.setTextContent("张三");
            //6 添加子节点
            root_class.appendChild(student);
            student.appendChild(name);
            //7 讲根节点添加到document
            document.appendChild(root_class);
            //创建转换类工厂
            TransformerFactory transformerFactory=TransformerFactory.newInstance();
            //创建转换者类
            Transformer transformer=transformerFactory.newTransformer();
            //设置换行属性
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            transformer.setOutputProperty(OutputKeys.ENCODING,"gbk");
            //进行转换
            transformer.transform(new DOMSource(document),new StreamResult(new File("student2.xml")));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
