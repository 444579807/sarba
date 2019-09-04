package org.sarba.java.refactor.initial;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-07-16 15:29
 * @description:
 **/
public class Customer {

    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        this._name = name;
    }

    public void addRental(Rental arg){
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
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();
            switch (each.get_movie().get_priceCode()){
                case Movie.REGULAR:
                    thisAmount += 2;
                    if(each.get_daysRentad() > 2)
                        thisAmount += (each.get_daysRentad() - 2) * 1.5 ;
                    break;
                case Movie.NEW_RELEASE :
                    thisAmount += each.get_daysRentad() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += each.get_daysRentad() * 1.5;
                    if(each.get_daysRentad() > 3)
                        thisAmount += (each.get_daysRentad() - 3) * 1.5 ;
                    break;
            }
            frequestRentalPoints++;
            if(each.get_movie().get_priceCode() == Movie.NEW_RELEASE && each.get_daysRentad() > 1)
                frequestRentalPoints++;
            result = "\t" + each.get_movie().get_title()+"\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n" ;
        result += "Your earned " + String.valueOf(frequestRentalPoints) + " frequest rental point " ;
        return result;
    }

}
