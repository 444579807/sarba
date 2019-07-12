package org.sarba.java.bean.entity;

import java.util.Date;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-05-15 14:52
 * @description: 子类实体
 **/
public class Sub extends Parant {

    private String subName;
    private int subAge;
    private Date subBorn;

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public int getSubAge() {
        return subAge;
    }

    public void setSubAge(int subAge) {
        this.subAge = subAge;
    }

    public Date getSubBorn() {
        return subBorn;
    }

    public void setSubBorn(Date subBorn) {
        this.subBorn = subBorn;
    }

}
