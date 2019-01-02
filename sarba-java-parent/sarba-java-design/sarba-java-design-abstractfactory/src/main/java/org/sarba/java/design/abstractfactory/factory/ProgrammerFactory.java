package org.sarba.java.design.abstractfactory.factory;

import org.sarba.java.common.inter.DataBases;
import org.sarba.java.common.inter.Programmer;
import org.sarba.java.common.inter.impl.JavaProgrammer;
import org.sarba.java.common.inter.impl.PhpProgrammer;
import org.sarba.java.common.inter.impl.PythonProgrammer;
import org.sarba.java.design.abstractfactory.Abstractfactory;

public  class ProgrammerFactory extends Abstractfactory {
    @Override
    public Programmer getProgrammer(String type) {
        if(type == null){
            return null;
        }
        if(type.equals("java")){
            return new JavaProgrammer();
        }else  if(type.equals("python")){
            return new PythonProgrammer();
        }else if(type.equals("php")){
            return new PhpProgrammer();
        }

        return null;
    }

    public DataBases getDataBases(String type) {
        return null;
    }
}
