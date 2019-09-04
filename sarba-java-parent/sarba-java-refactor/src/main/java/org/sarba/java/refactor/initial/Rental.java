package org.sarba.java.refactor.initial;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-07-16 15:27
 * @description:
 **/
public class Rental {

    private Movie _movie;
    private int   _daysRentad;

    public Rental(Movie _movie, int _daysRentad) {
        this._movie = _movie;
        this._daysRentad = _daysRentad;
    }

    public Movie get_movie() {
        return _movie;
    }

    public int get_daysRentad() {
        return _daysRentad;
    }
}
