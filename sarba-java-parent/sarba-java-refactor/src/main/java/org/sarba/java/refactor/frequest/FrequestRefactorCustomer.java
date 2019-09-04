package org.sarba.java.refactor.frequest;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-07-17 10:16
 * @description:
 **/
public class FrequestRefactorCustomer {

    private String _name;
    private Vector _rentals = new Vector();

    public FrequestRefactorCustomer(String name) {
        this._name = name;
    }

    public void addRental(FrequestRental arg){
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
            FrequestRental each = (FrequestRental) rentals.nextElement();
            frequestRentalPoints = each.getFrequestRentalPoints();
            result = "\t" + each.get_movie().get_title()+"\t" + String.valueOf(each.getChange()) + "\n";
            totalAmount += each.getChange();
        }
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n" ;
        result += "Your earned " + String.valueOf(frequestRentalPoints) + " frequest rental point " ;
        return result;
    }

}
