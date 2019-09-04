package org.sarba.java.refactor.state;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-07-17 15:41
 * @description:
 **/
public class RegularPrice extends Price {
    @Override
    public int getPriceCode() {
        return StateMovie.REGULAR;
    }

    @Override
    public double getChange(int dayRented) {
        double result = 2;
        if(dayRented > 2){
            result += (dayRented - 2 ) * 1.5 ;
        }
        return result;
    }
}
