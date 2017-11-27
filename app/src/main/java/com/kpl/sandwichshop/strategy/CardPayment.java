package com.kpl.sandwichshop.strategy;

import android.util.Log;

import com.kpl.sandwichshop.builder.Sandwich;

/**
 * Created by Ilham Aulia Majid on 28-Nov-17.
 */

public class CardPayment implements PaymentMethod {

    private final String TAG = getClass().getSimpleName();

    @Override
    public void processPayment(int price, int value) {
        int cardNumber = value;
        Log.d(TAG, "Card number = " + cardNumber);
    }
}
