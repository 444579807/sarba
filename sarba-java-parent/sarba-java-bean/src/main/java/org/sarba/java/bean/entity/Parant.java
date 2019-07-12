package org.sarba.java.bean.entity;

import java.util.Date;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-05-15 14:51
 * @description: 父类实体
 **/
public class Parant {

    private String parentName;
    private int parentAge;
    private Date parentBorn;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public int getParentAge() {
        return parentAge;
    }

    public void setParentAge(int parentAge) {
        this.parentAge = parentAge;
    }

    public Date getParentBorn() {
        return parentBorn;
    }

    public void setParentBorn(Date parentBorn) {
        this.parentBorn = parentBorn;
    }
}
