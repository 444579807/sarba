package org.sarba.java.refactor.second;

import org.sarba.java.refactor.initial.Movie;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-07-17 10:16
 * @description:
 **/
public class SecondRefactorCustomer {

    private String _name;
    private Vector _rentals = new Vector();

    public SecondRefactorCustomer(String name) {
        this._name = name;
    }

    public void addRental(SecondRental arg){
        this._rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement(){
        double totalAmount = 0;
        int  frequestRentalPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "rental record for :" + getName() + "\n";
        while(rentals.hasMoreElements()){
            SecondRental each = (SecondRental) rentals.nextElement();
            frequestRentalPoints++;
            if(each.get_movie().get_priceCode() == Movie.NEW_RELEASE && each.get_daysRentad() > 1)
                frequestRentalPoints++;
            result = "\t" + each.get_movie().get_title()+"\t" + String.valueOf(each.getChange()) + "\n";
            totalAmount += each.getChange();
        }
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n" ;
        result += "Your earned " + String.valueOf(frequestRentalPoints) + " frequest rental point " ;
        return result;
    }

}
