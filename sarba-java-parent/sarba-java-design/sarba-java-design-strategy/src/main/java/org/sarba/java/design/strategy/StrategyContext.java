package org.sarba.java.design.strategy;

import org.sarba.java.common.inter.Programmer;

public class StrategyContext {

    private Programmer strategy ;

    public StrategyContext(Programmer strategy) {
        this.strategy = strategy;
    }

    public void say(){
        this.strategy.language();
    }
}
