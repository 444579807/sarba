package org.sarba.java.xml;

import org.sarba.java.xml.bean.Parent;
import org.sarba.java.xml.xmlbeans.XStreamDemo;
import org.sarba.java.xml.xmlbeans.XmlEncoderDemo;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        /*XmlEncoderDemo xmlEncoderDemo = new XmlEncoderDemo();
        try {
            xmlEncoderDemo.xmlEncoder();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        XStreamDemo streamDemo = new XStreamDemo();
        Parent parent = streamDemo.formatParent();
            long start = System.currentTimeMillis();
            String xml = streamDemo.toXml(parent);
            long end = System.currentTimeMillis();
            System.out.println("sum : " + (end-start));
          streamDemo.saveAsFileWriter(xml);
        System.out.println("size : " + xml.length());
        //System.out.println(xml);
        for (int i = 0; i <100000 ; i++) {
            long start1 = System.currentTimeMillis();
            XStreamDemo.toBean(xml,Parent.class);
            long end1 = System.currentTimeMillis();
            System.out.println("sum1 : " + i +" ," + (end1-start1));
        }


    }


}
