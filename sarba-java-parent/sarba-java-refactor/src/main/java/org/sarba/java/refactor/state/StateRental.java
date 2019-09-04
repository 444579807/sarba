package org.sarba.java.refactor.state;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-07-16 15:27
 * @description:
 **/
public class StateRental {

    private StateMovie _movie;
    private int   _daysRentad;

    public StateRental(StateMovie _movie, int _daysRentad) {
        this._movie = _movie;
        this._daysRentad = _daysRentad;
    }

    public StateMovie get_movie() {
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
