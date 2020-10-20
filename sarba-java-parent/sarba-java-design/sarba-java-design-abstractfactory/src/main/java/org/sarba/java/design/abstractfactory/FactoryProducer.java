package org.sarba.java.design.abstractfactory;

import org.sarba.java.design.abstractfactory.factory.DataBasesFactory;
import org.sarba.java.design.abstractfactory.factory.ProgrammerFactory;

public class FactoryProducer {

    public static Abstractfactory getFactory(String type){
        if(type.equals("database")){
            return new DataBasesFactory();
        }else if(type.equals("programmer")){
            return new ProgrammerFactory();
        }
        return null;
    }
}
