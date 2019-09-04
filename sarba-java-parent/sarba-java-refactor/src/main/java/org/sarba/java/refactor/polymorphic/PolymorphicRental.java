package org.sarba.java.refactor.polymorphic;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-07-16 15:27
 * @description:
 **/
public class PolymorphicRental {

    private PolymorphicMovie _movie;
    private int   _daysRentad;

    public PolymorphicRental(PolymorphicMovie _movie, int _daysRentad) {
        this._movie = _movie;
        this._daysRentad = _daysRentad;
    }

    public PolymorphicMovie get_movie() {
        return _movie;
    }

    public int get_daysRentad() {
        return _daysRentad;
    }

    public double getChange(){
        return _movie.getChange(this._daysRentad);
    }

    public int getFrequestRentalPoints(){
       return _movie.getFrequestRentalPoints(this._daysRentad);
    }
}
