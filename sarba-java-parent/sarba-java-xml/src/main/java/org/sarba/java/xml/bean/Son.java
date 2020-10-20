package org.sarba.java.xml.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;
import java.util.List;
@XStreamAlias(value = "son")
public class Son implements Serializable{

    private String name;
    private Integer age;
    private List<Children> childrens;

    public Son(){}

    public Son(String name,Integer age,List<Children> childrens){
        this.name = name;
        this.age = age;
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

    public List<Children> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Children> childrens) {
        this.childrens = childrens;
    }
}
