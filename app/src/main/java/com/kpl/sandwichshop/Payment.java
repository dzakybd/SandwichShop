package com.kpl.sandwichshop;

import com.kpl.sandwichshop.strategy.CashPayment;
import com.kpl.sandwichshop.strategy.PaymentMethod;

/**
 * Created by Ilham Aulia Majid on 28-Nov-17.
 */

public class Payment {

    PaymentMethod paymentMethod;
    int price;
    int value;

    public Payment(/*Sandwich sandwich*/) {
//        this.price = sandwich.getPrice();
        this.price = 20000;
        this.paymentMethod = new CashPayment();
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String pay() {
        return paymentMethod.processPayment(price, value);
    }
}
