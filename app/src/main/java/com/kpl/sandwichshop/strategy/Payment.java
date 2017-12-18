package com.kpl.sandwichshop.strategy;

import com.kpl.sandwichshop.Sandwich;
import com.kpl.sandwichshop.strategy.CashPayment;
import com.kpl.sandwichshop.strategy.PaymentMethod;

/**
 * Created by Ilham Aulia Majid on 28-Nov-17.
 */

public class Payment {

    int price;

    public Payment(Sandwich sandwich) {
        this.price = sandwich.getPrice();
    }

    public String pay(PaymentMethod paymentMethod){
        return paymentMethod.processPayment(price);
    }
}
