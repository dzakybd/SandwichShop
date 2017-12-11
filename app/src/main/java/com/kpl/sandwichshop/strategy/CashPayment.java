package com.kpl.sandwichshop.strategy;


import com.kpl.sandwichshop.StaticKeys;

/**
 * Created by Ilham Aulia Majid on 27-Nov-17.
 */

public class CashPayment implements PaymentMethod {

    private final String TAG = getClass().getSimpleName();

    @Override
    public String processPayment(int price, String value) {
        int cash = Integer.parseInt(value);
        if (cash >= price) {
            return "Cash : " + cash + "\nChange : " + (cash - price);
        } else {
            return StaticKeys.CASH_FAILED;
        }
    }
}
