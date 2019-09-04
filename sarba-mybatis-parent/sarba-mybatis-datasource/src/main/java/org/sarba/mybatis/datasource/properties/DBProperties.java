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

    public  DataBases getDataBases(String database) {
        return getDataBases(null,null,database,null);
    }
    public  DataBases getDataBases(String host,String database) {
        return getDataBases(host,null,database,null);
    }

    public  DataBases getDataBases(String host,String database,String password) {
        return getDataBases(host,null,database,password);
    }

    public DataBases getDataBases(String host,String port,String database,String password){
        String url = dataBases.getUrl();
        if(host != null){
            url = url.replace("127.0.0.1",host);
        }
        if(port != null){
            url =  url.replace("3306",port);
        }
        if(database != null){
            url = url.replace("mybatis",database);
        }
        DataBases bases = (DataBases) dataBases.clone();
        bases.setUrl(url);
        if(password != null){
            bases.setPassWord(password);
        }
        return bases;
    }


}
