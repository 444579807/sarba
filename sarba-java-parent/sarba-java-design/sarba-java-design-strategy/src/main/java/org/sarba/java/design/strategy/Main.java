package org.sarba.java.design.strategy;

import org.sarba.java.common.inter.impl.JavaProgrammer;
import org.sarba.java.common.inter.impl.PhpProgrammer;
import org.sarba.java.common.inter.impl.PythonProgrammer;

public class Main {

    public static void main(String[] args) {
        StrategyContext context = new StrategyContext(new JavaProgrammer());
        context.say();
        StrategyContext context1 = new StrategyContext(new PythonProgrammer());
        context1.say();
        StrategyContext context2 = new StrategyContext(new PhpProgrammer());
        context2.say();
    }

}
