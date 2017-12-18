package com.kpl.sandwichshop.strategy;

import com.kpl.sandwichshop.Sandwich;

/**
 * Created by Ilham Aulia Majid on 28-Nov-17.
 */

public class Payment {

    private int price;

    public Payment(Sandwich sandwich) {
        this.price = sandwich.getPrice();
    }

    public String pay(PaymentMethod paymentMethod){
        return paymentMethod.processPayment(price);
    }
}
