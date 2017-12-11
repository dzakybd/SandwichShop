package com.kpl.sandwichshop.strategy;


import com.kpl.sandwichshop.StaticKeys;

/**
 * Created by Ilham Aulia Majid on 27-Nov-17.
 */

public class CashPayment implements PaymentMethod {

    private final String TAG = getClass().getSimpleName();

    @Override
    public String processPayment(int price, int value) {
        int cash = value;
        if (cash > price) {
            return "Cash\t\t= " + cash + "\nChange\t\t= " + (cash - price);
        } else {
            return StaticKeys.FAILED;
        }
    }
}
