package org.sarba.java.design.abstractfactory.factory;

import org.sarba.java.common.inter.DataBases;
import org.sarba.java.common.inter.Programmer;
import org.sarba.java.common.inter.impl.MysqlDatabase;
import org.sarba.java.common.inter.impl.OracleDataBase;
import org.sarba.java.common.inter.impl.SqlServerDataBase;
import org.sarba.java.design.abstractfactory.Abstractfactory;

public class DataBasesFactory extends Abstractfactory{
    public Programmer getProgrammer(String type) {
        return null;
    }

    public DataBases getDataBases(String type) {

        if(type == null){
            return null;
        }
        if(type.equals("mysql")){
            return new MysqlDatabase();
        }else  if(type.equals("sqlserver")){
            return new SqlServerDataBase();
        }else  if(type.equals("oracle")){
            return new OracleDataBase();
        }


        return null;
    }
}
