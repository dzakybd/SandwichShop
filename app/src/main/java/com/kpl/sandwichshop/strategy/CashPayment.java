package com.kpl.sandwichshop.strategy;


import com.kpl.sandwichshop.StaticKeys;

/**
 * Created by Ilham Aulia Majid on 27-Nov-17.
 */

public class CashPayment implements PaymentMethod {

    private int cashValue;

    public CashPayment(int cashValue){
        this.cashValue=cashValue;
    }

    @Override
    public String processPayment(int price) {
        if (cashValue >= price) {
            return price +" paid with cash, return "+ (cashValue - price);
        } else {
            return StaticKeys.CASH_INSUFFICIENT;
        }
    }
}
