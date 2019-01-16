package org.sarba.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloBean helloBean = applicationContext.getBean("helloBean",HelloBean.class);
        helloBean.say();
        helloBean.setName("setName");
        helloBean.say();

        ExampleBean exampleBean = applicationContext.getBean("exampleBean", ExampleBean.class);
        exampleBean.say();

        StaticFactoryBean staticFactoryBean = applicationContext.getBean("staticFactoryBean",StaticFactoryBean.class);
        staticFactoryBean.say();
    }

}
