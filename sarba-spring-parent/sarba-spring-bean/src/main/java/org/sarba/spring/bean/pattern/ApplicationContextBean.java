package org.sarba.spring.bean.pattern;

import org.sarba.spring.bean.pattern.anno.AnnoBean;
import org.sarba.spring.bean.pattern.javaBean.JavaBean;
import org.sarba.spring.bean.pattern.xml.XMLBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-07-12 14:58
 * @description: 通过ApplicationContext获取bean
 **/
public class ApplicationContextBean {

    public static void main(String[] args) {
        // 此方法只能获取到通过xml方式配置的bean,通过其他方式配置的bean获取不到
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
        XMLBean xmlBean = (XMLBean) applicationContext.getBean("xmlBean");
        xmlBean.getMessage();
    }

}
