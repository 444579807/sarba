package org.sarba.spring.bean.pattern;

import org.sarba.spring.bean.pattern.anno.AnnoBean;
import org.sarba.spring.bean.pattern.javaBean.BeanConfiguration;
import org.sarba.spring.bean.pattern.javaBean.JavaBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-07-12 15:28
 * @description: 基于AnnotationConfigApplicationContext 获取bean
 **/
public class AnnoConfigurationBean {

    public static void main(String[] args) {
        //只能获取通过具体配置文件加载的bean
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        JavaBean javaBean = (JavaBean)applicationContext.getBean("javaBean");
        javaBean.getMessage();

    }

}
