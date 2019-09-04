package org.sarba.spring.bean.pattern;

import org.sarba.spring.bean.pattern.anno.AnnoBean;
import org.sarba.spring.bean.pattern.javaBean.BeanConfiguration;
import org.sarba.spring.bean.pattern.javaBean.JavaBean;
import org.sarba.spring.bean.pattern.xml.XMLBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-07-12 16:17
 * @description: 基于xml,component,java三种方式定义的bean的获取方法
 **/
public class AllMain {

    public static void main(String[] args) {
        //通过xml 定义的bean 必须通过加载xml的方式获取
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:beans.xml");
        XMLBean xmlBean = (XMLBean) applicationContext.getBean("xmlBean");
        xmlBean.getMessage();
        // 通过在配置文件中加载 <context:annotation-config /> <context:component-scan base-package="org.sarba.spring.bean.pattern.anno" /> 注解也可以获取到注解配置的bean
        AnnoBean annoBean = (AnnoBean)applicationContext.getBean("annoBean");
        annoBean.getMessage();
        //通过java方式加载的bean 必须通过加载配置文件的方式获取bean
        ApplicationContext applicationContext1 = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        JavaBean javaBean = (JavaBean)applicationContext1.getBean("javaBean");
        javaBean.getMessage();
        // 通过注解扫描包的方式加载bean，可以获取 java配置文件方式，注解方式加载的bean信息
        ApplicationContext applicationContext2 = new AnnotationConfigApplicationContext("org.sarba.spring.bean.pattern.*");
        AnnoBean annoBean2 = (AnnoBean)applicationContext2.getBean("annoBean");
        annoBean2.getMessage();
        JavaBean javaBean2 = (JavaBean)applicationContext2.getBean("javaBean");
        javaBean2.getMessage();
    }

}
