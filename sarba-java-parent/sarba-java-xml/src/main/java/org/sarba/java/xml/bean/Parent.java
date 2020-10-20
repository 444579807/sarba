package org.sarba.java.xml.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import java.io.Serializable;
import java.util.List;

@XStreamAlias(value = "parent")
public class Parent implements Serializable{

    private String name;
    private Integer age;
    private Son  son;
    private List<Children> childrens;

    public Parent(){}

    public Parent(String name, Integer age, Son son,List<Children> childrens) {
        this.name = name;
        this.age = age;
        this.son = son;
        this.childrens = childrens;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Son getSon() {
        return son;
    }

    public void setSon(Son son) {
        this.son = son;
    }
}
