package com.landi.trainingdemo.xml;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import java.io.File;
import java.net.URL;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

/**
 * Created by guoj on 2019/6/9.
 */

public class Sax2Xml {
    public static void main(String[] args) {
        creatXML();
    }

    private static void creatXML() {
        //1创建转换xml的工厂类SAXTransformerFactory
        SAXTransformerFactory saxTransformerFactory= (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        try {
            //2创建一个转换操作类transformerHandler
            TransformerHandler transformerHandler=saxTransformerFactory.newTransformerHandler();
            //3获取一个转换类
            Transformer transformer=transformerHandler.getTransformer();
            //4设置输出的xml属性
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            transformer.setOutputProperty(OutputKeys.ENCODING,"utf-8");
            //5.创建Result
            Result result=new StreamResult(new File("student2.xml"));
            //6.给handler设置输出结果
            transformerHandler.setResult(result);
            //7 使用handle创建xml的节点
            transformerHandler.startDocument();
            AttributesImpl attr=new AttributesImpl();
            transformerHandler.startElement("","","class",attr);
            attr.clear();
            attr.addAttribute("","","id","","1");
            transformerHandler.startElement("","","student",attr);
            attr.clear();
            transformerHandler.startElement("","","name",attr);
            char[] chars="小海".toCharArray();
            transformerHandler.characters(chars,0,chars.length);
            transformerHandler.endElement("","","name");
            transformerHandler.endElement("","","student");
            transformerHandler.endElement("","","class");
            transformerHandler.endDocument();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }
}
