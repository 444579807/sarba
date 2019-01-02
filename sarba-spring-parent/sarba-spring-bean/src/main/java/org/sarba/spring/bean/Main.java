package org.sarba.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloBean helloBean = (HelloBean) applicationContext.getBean("helloBean");
        helloBean.say();
        helloBean.setName("setName");
        helloBean.say();
    }

}
