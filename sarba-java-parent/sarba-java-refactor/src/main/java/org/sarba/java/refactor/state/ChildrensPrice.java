package org.sarba.java.refactor.state;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-07-17 15:41
 * @description:
 **/
public class ChildrensPrice extends Price {
    @Override
    public int getPriceCode() {
        return StateMovie.CHILDRENS;
    }

    @Override
    public double getChange(int dayRented) {
        double result = 1.5;
        if(dayRented > 3){
            result += (dayRented - 3 ) * 1.5 ;
        }
        return result;
    }
}
