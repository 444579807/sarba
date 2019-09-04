package org.sarba.java.refactor.state;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-07-17 15:39
 * @description:
 **/
public abstract class Price {

   public  abstract int getPriceCode();

   public  abstract double getChange(int dayRented);

   public int getFrequestRentalPoints(int dayRented){
       return 1 ;
   }

}
