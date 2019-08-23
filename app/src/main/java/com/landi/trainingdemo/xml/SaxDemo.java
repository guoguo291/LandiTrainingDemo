package com.landi.trainingdemo.xml;

import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by guoj on 2019/6/2.
 */

public class SaxDemo {
    public static void main(String []args){
        parseXmlBySax();
    }

    private static void parseXmlBySax() {
        SAXParserFactory factory=SAXParserFactory.newInstance();
        try {
            SAXParser saxParser=factory.newSAXParser();
            saxParser.parse(new File("students.xml"),new SaxHandler());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
