package org.sarba.spring.bean.pattern;

import org.sarba.spring.bean.pattern.anno.AnnoBean;
import org.sarba.spring.bean.pattern.javaBean.BeanConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-07-12 16:07
 * @description: 通过component注解注入的bean获取
 **/
public class ComponentBean {

    public static void main(String[] args) {
        //获取注解ComponentScan扫描到的包下的bean
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("org.sarba.spring.bean.pattern.anno");
        AnnoBean annoBean = (AnnoBean)applicationContext.getBean("annoBean");
        annoBean.getMessage();

    }
}
