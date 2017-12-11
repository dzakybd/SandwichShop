package com.kpl.sandwichshop.strategy;

import com.kpl.sandwichshop.StaticKeys;

/**
 * Created by Ilham Aulia Majid on 28-Nov-17.
 */

public class CardPayment implements PaymentMethod {

    private final String TAG = getClass().getSimpleName();

    @Override
    public String processPayment(int price, String value) {
        String cardNumber = value;
        if (cardNumber.trim().length() == 16) {
            return "Card number : " + cardNumber;
        } else {
            return StaticKeys.CARD_FAILED;
        }
    }
}
