package org.sarba.mybatis.datasource.properties;

import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum  DBProperties {

    INSTANCE;

    private static DataBases dataBases;

    static{
        try {
            InputStream inputStream = Resources.getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            dataBases = new DataBases();
            dataBases.setDriverClassName(properties.getProperty("db.driver"));
            dataBases.setUrl(properties.getProperty("db.url"));
            dataBases.setUserName(properties.getProperty("db.name"));
            dataBases.setPassWord(properties.getProperty("db.pswd"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  DataBases getDataBases() {
        return dataBases;
    }
}
