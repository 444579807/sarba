package org.sarba.mybatis.datasource.properties;

import java.io.Serializable;

public class DataBases implements Serializable,Cloneable {

    private String driverClassName;
    private String url;
    private String userName;
    private String passWord;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    protected Object clone(){
        Object o = null;
        try {
            //Object中的clone()识别出你要复制的是哪一个对象
            o = (DataBases) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.toString());
        }
        return o;
    }
}
