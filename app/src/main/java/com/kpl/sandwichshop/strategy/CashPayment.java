package com.kpl.sandwichshop.strategy;


import android.util.Log;

import com.kpl.sandwichshop.builder.Sandwich;

/**
 * Created by Ilham Aulia Majid on 27-Nov-17.
 */

public class CashPayment implements PaymentMethod {

    private final String TAG = getClass().getSimpleName();

    @Override
    public void processPayment(int price, int value) {
        int cash = value;
        if(cash > price) {
            Log.d(TAG, "Return = " + (cash - price));
        }
        else {
            Log.d(TAG, "Failed");
        }
    }
}
