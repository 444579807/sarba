package org.sarba.java.refactor.polymorphic;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-07-16 15:23
 * @description:
 **/
public class PolymorphicMovie {

    public static final int CHILDRENS= 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int    _priceCode;

    public PolymorphicMovie(String _title, int _priceCode) {
        this._title = _title;
        this._priceCode = _priceCode;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public int get_priceCode() {
        return _priceCode;
    }

    public void set_priceCode(int _priceCode) {
        this._priceCode = _priceCode;
    }

    public double getChange(int dayRented){
        double result = 0;
        switch (get_priceCode()){
            case PolymorphicMovie.REGULAR:
                result +=2;
                if(dayRented > 2)
                    result += (dayRented - 2) * 1.5 ;
                break;
            case PolymorphicMovie.NEW_RELEASE :
                result +=  dayRented * 3;
                break;
            case PolymorphicMovie.CHILDRENS:
                result += dayRented * 1.5;
                if(dayRented > 3)
                    result += (dayRented - 3) * 1.5 ;
                break;
        }
        return result;
    }

    public int getFrequestRentalPoints(int dayRented){
        if(get_priceCode() == PolymorphicMovie.NEW_RELEASE && dayRented > 1){
            return 2;
        }else{
            return 1;
        }
    }
}
