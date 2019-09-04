package org.sarba.java.refactor.state;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-07-16 15:23
 * @description:
 **/
public class StateMovie {

    public static final int CHILDRENS= 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String  _title;
    private int     _priceCode;
    private Price   _price;

    public StateMovie(String _title, int _priceCode) {
        this._title = _title;
        set_priceCode(_priceCode);
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public int get_priceCode() {
        return _price.getPriceCode();
    }

    public void set_priceCode(int _priceCode) {
        switch (_priceCode){
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDRENS:
                _price = new ChildrensPrice();
                break;
            case NEW_RELEASE :
                _price = new NewReleasePrice();
                break;
             default:
                 throw new IllegalArgumentException("Incorrect Price Code");
        }

    }

    public double getChange(int dayRented){
       return _price.getChange(dayRented);
    }

    public int getFrequestRentalPoints(int dayRented){
        return _price.getFrequestRentalPoints(dayRented);
    }
}
