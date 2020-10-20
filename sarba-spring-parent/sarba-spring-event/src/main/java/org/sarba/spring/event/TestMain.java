package org.sarba.spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args) {
       /* //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //TestApplicationEvent event = new TestApplicationEvent(new TestMain(),"hello world ! ");
        //applicationContext.publishEvent(event);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(TestApplicationListener.class,TestApplicationListener2.class);
        context.register(AsycConfig.class);
        context.refresh();

        TestApplicationEvent event = new TestApplicationEvent(new TestMain(),"hello world ! ");
        context.publishEvent(event);
        System.out.println(Thread.currentThread().getId() + "   msg :  hello world !" );*/

        String str = "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDABALDA4MChAODQ4SERATGCgaGBYWGDEjJR0oOjM9PDkz";
        System.out.println(str.length());


    }

}
