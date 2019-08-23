package com.landi.trainingdemo.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by guoj on 2019/6/3.
 */

public class SaxHandler extends DefaultHandler {
    int sumNo=0;
    Student student;
    ArrayList<Student> students;
    String value;
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        students=new ArrayList<Student>();
        System.out.println("==========SAX解析开始==========");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("==========SAX解析结束==========");
        for (int i = 0; i <students.size() ; i++) {
            Student student1=students.get(i);

            System.out.println(student1.toString());
        }
        student=null;
        students=null;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if("student".equals(qName)){
            sumNo++;
            System.out.println("-------------------------------");
            System.out.println("解析第:"+sumNo+"个学生");
            student=new Student();
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println(attributes.getQName(i)+":"+attributes.getValue(i));
                if ("id".equals(attributes.getQName(i))){
                    student.setId(attributes.getValue(i));
                }
            }
        }else if (!"student".equals(qName)&&!"class".equals(qName)){
            System.out.print("节点名："+qName);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if("student".equals(qName)){
            students.add(student);
        }else if (!"student".equals(qName)&&!"class".equals(qName)){
            if("name".equals(qName)){
                student.setName(value);
            }else if ("sex".equals(qName)){
                student.setSex(value);
            }else if("age".equals(qName)){
                student.setAge(value);
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
         value=new String(ch,start,length);
        if (value!=null&&!value.trim().isEmpty()){
            System.out.println("："+value);
        }
    }
}
