package org.sarba.java.refactor.state;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-07-17 15:41
 * @description:
 **/
public class NewReleasePrice extends Price {
    @Override
    public int getPriceCode() {
        return StateMovie.NEW_RELEASE;
    }

    @Override
    public double getChange(int dayRented) {
        return dayRented * 3;
    }

    @Override
    public int getFrequestRentalPoints(int dayRented) {
        return (dayRented > 1) ? 2 : 1;
    }
}
