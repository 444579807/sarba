package org.sarba.java.design.abstractfactory;

import org.sarba.java.common.inter.DataBases;
import org.sarba.java.common.inter.Programmer;

public abstract class Abstractfactory {

    public abstract Programmer getProgrammer(String type);
    public abstract DataBases getDataBases(String type);

}
