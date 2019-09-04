package org.sarba.java.refactor.temp;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-07-17 10:16
 * @description:
 **/
public class TempRefactorCustomer {

    private String _name;
    private Vector _rentals = new Vector();

    public TempRefactorCustomer(String name) {
        this._name = name;
    }

    public void addRental(TempRental arg){
        this._rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement(){
        Enumeration rentals = _rentals.elements();
        String result = "rental record for :" + getName() + "\n";
        while(rentals.hasMoreElements()){
            TempRental each = (TempRental) rentals.nextElement();
            result = "\t" + each.get_movie().get_title()+"\t" + String.valueOf(each.getChange()) + "\n";
        }
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n" ;
        result += "Your earned " + String.valueOf(getTotalFrequestRentalPoints()) + " frequest rental point " ;
        return result;
    }

    private double getTotalCharge(){
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while(rentals.hasMoreElements()){
            TempRental each = (TempRental) rentals.nextElement();
            result += each.getChange();
        }
        return result;
    }

    private int getTotalFrequestRentalPoints(){
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while(rentals.hasMoreElements()){
            TempRental each = (TempRental) rentals.nextElement();
            result += each.getFrequestRentalPoints();
        }
        return result;
    }

}
