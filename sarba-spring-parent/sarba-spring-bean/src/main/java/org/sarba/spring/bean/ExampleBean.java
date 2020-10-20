package org.sarba.spring.bean;

public class ExampleBean {

    private String name ;

    public ExampleBean(String name){
        this.name = name;
    }

    public void say(){
        System.out.println("构造函数bean : " + name);
    }

}
