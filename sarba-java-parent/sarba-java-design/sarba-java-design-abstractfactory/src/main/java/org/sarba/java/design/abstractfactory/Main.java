package org.sarba.java.design.abstractfactory;

public class Main  {

    public static void main(String[] args) {
        Abstractfactory dataBasesFactory = FactoryProducer.getFactory("database");
        dataBasesFactory.getDataBases("mysql").dataBases();
        dataBasesFactory.getDataBases("sqlserver").dataBases();
        dataBasesFactory.getDataBases("oracle").dataBases();
        Abstractfactory programmerFactory = FactoryProducer.getFactory("programmer");
        programmerFactory.getProgrammer("java").language();
        programmerFactory.getProgrammer("python").language();
        programmerFactory.getProgrammer("php").language();
    }

}
