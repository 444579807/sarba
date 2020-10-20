package org.sarba.java.xml.xmlbeans;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import org.sarba.java.xml.bean.Children;
import org.sarba.java.xml.bean.Parent;
import org.sarba.java.xml.bean.Son;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XStreamDemo {

   private static XStream xStream = new XStream(new Dom4JDriver());
   static {
       XStream.setupDefaultSecurity(xStream);
       xStream.allowTypes(new Class[]{Children.class});
       xStream.allowTypes(new Class[]{Son.class});
       xStream.allowTypes(new Class[]{Parent.class});
       xStream.autodetectAnnotations(true);
   }

    public static  <T> T toBean(String xmlStr, Class<T> cls) {

        xStream.processAnnotations(cls);
        T obj = (T) xStream.fromXML(xmlStr);

        return obj;

    }

    public Parent formatParent(){
        List<Children> children = new ArrayList<>();
        for (int i=0; i< 1000; i++){
            children.add(new Children("fdsfdsfds",32));
        }
        Parent parent = new Parent("parent",43,new Son("son",32,children),children);
        return parent;
    }

    public String toXml(Parent parent){
        XStream xStream = new XStream(new Dom4JDriver());
        xStream.autodetectAnnotations(true);
        return xStream.toXML(parent);
    }

    public  void saveAsFileWriter(String content) {

        FileWriter fwriter = null;
        try {
            fwriter = new FileWriter("D:\\test.xml");
            fwriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
