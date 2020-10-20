package org.sarba.java.xml.xmlbeans;

import org.sarba.java.xml.bean.Children;
import org.sarba.java.xml.bean.Parent;
import org.sarba.java.xml.bean.Son;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class XmlEncoderDemo {
    //将对象写入XML文档中
    public void xmlEncoder() throws FileNotFoundException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("D:/test.xml"));
        XMLEncoder xmlEncoder = new XMLEncoder(bufferedOutputStream);
        //实例化的类必须是public 否则会报错
        List<Children> children = new ArrayList<>();
        children.add(new Children("fdsfdsfds",32));
        children.add(new Children("fdsfdssfds",32));
        children.add(new Children("fdsfdsf3fds",32));
        children.add(new Children("fdsfdfdsa23fs",32));
        children.add(new Children("fdsfdsafds",32));
        children.add(new Children("fdsdsfds",32));
        children.add(new Children("fdsafdsfds",32));
        children.add(new Children("fdsfds",32));
        children.add(new Children("fdsffdsds",32));
        children.add(new Children("fdsgfdfds",32));
        children.add(new Children("fdsgfdfds",32));
        children.add(new Children("fdsffsfds",32));

        Parent parent = new Parent("parent",43,new Son("son",32,children),children);
        xmlEncoder.writeObject(parent);
        xmlEncoder.close();
    }

}
