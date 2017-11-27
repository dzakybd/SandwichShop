package com.kpl.sandwichshop;

import com.kpl.sandwichshop.builder.Sandwich;
import com.kpl.sandwichshop.strategy.CashPayment;
import com.kpl.sandwichshop.strategy.PaymentMethod;

/**
 * Created by Ilham Aulia Majid on 28-Nov-17.
 */

public class Payment {

    PaymentMethod paymentMethod;
    int price;
    int value;

    public Payment(Sandwich sandwich) {
        this.price = sandwich.getPrice();
        this.paymentMethod = new CashPayment();
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void pay() {
        paymentMethod.processPayment(price, value);
    }
}
