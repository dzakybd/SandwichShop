package com.kpl.sandwichshop.strategy;


import com.kpl.sandwichshop.StaticKeys;

/**
 * Created by Ilham Aulia Majid on 27-Nov-17.
 */

public class CashPayment implements PaymentMethod {

    private int cashvalue;

    public CashPayment(int cashvalue){
        this.cashvalue=cashvalue;
    }

    @Override
    public String processPayment(int price) {
        if (cashvalue >= price) {
            return price +" paid with cash, return "+ (cashvalue - price);
        } else {
            return StaticKeys.CASH_INSUFFICIENT;
        }
    }
}
