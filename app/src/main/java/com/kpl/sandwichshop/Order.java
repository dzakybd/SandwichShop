package com.kpl.sandwichshop;

import com.kpl.sandwichshop.builder.Sandwich;

import java.io.Serializable;

/**
 * Created by Ilham Aulia Majid on 12-Dec-17.
 */

public class Order implements Serializable {

    Sandwich sandwich;
    String bonus;
    String paymentMessage;

    public Sandwich getSandwich() {
        return sandwich;
    }

    public void setSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getPaymentMessage() {
        return paymentMessage;
    }

    public void setPaymentMessage(String paymentMessage) {
        this.paymentMessage = paymentMessage;
    }
}
