package org.sarba.java.design.factory;


import org.sarba.java.common.inter.Programmer;
import org.sarba.java.common.inter.impl.JavaProgrammer;
import org.sarba.java.common.inter.impl.PhpProgrammer;
import org.sarba.java.common.inter.impl.PythonProgrammer;

public class ProgrammerFactory {

    public Programmer getProgrammer(String type){
        if(type == null){
            return null;
        }
        if(type.equals("java")){
            return new JavaProgrammer();
        }else if(type.equals("php")){
            return  new PhpProgrammer();
        }else if (type.equals("python")){
            return new PythonProgrammer();
        }
        return null;
    }
}
