package org.sarba.spring.bean;

public class StaticFactoryBean  {

    private String  name;

    private static StaticFactoryBean bean = new StaticFactoryBean();

    private StaticFactoryBean(){

    }

    public static StaticFactoryBean createBean(String name){
        bean.name = name;
        return bean;
    }

    public void say(){
        System.out.println("static factory bean : " + name);
    }

}
