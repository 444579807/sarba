package org.sarba.java.refactor.second;

import org.sarba.java.refactor.initial.Movie;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-07-16 15:27
 * @description:
 **/
public class SecondRental {

    private Movie _movie;
    private int   _daysRentad;

    public SecondRental(Movie _movie, int _daysRentad) {
        this._movie = _movie;
        this._daysRentad = _daysRentad;
    }

    public Movie get_movie() {
        return _movie;
    }

    public int get_daysRentad() {
        return _daysRentad;
    }

    public double getChange(){
        double result = 0;
        switch (get_movie().get_priceCode()){
            case Movie.REGULAR:
                result +=2;
                if(get_daysRentad() > 2)
                    result += (get_daysRentad() - 2) * 1.5 ;
                break;
            case Movie.NEW_RELEASE :
                result += get_daysRentad() * 3;
                break;
            case Movie.CHILDRENS:
                result += get_daysRentad() * 1.5;
                if(get_daysRentad() > 3)
                    result += (get_daysRentad() - 3) * 1.5 ;
                break;
        }
        return result;
    }
}
