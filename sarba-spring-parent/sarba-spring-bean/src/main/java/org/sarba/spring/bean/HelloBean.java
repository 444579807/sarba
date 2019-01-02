package org.sarba.spring.bean;

public class HelloBean {

    private String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void say(){
        System.out.println("spring hello : " + name);
    }
}
