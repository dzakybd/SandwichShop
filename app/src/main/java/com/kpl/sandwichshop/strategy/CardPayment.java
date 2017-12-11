package com.kpl.sandwichshop.strategy;

import android.util.Log;

/**
 * Created by Ilham Aulia Majid on 28-Nov-17.
 */

public class CardPayment implements PaymentMethod {

    private final String TAG = getClass().getSimpleName();

    @Override
    public String processPayment(int price, int value) {
        int cardNumber = value;
        return "Card number\t= " + cardNumber;
    }
}
