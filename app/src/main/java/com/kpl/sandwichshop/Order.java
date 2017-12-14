package com.kpl.sandwichshop;

import org.parceler.Parcel;

/**
 * Created by Ilham Aulia Majid on 12-Dec-17.
 */
@Parcel
public class Order {

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

    @Override
    public String toString() {
        String orderInfo = "";
        orderInfo += "Bread : " + sandwich.getBread().getName() + "\n";
        orderInfo += "Fillings : " + "------------" + "\n";
        orderInfo += "Toppings : " + sandwich.getName()
                .replace(" + Sandwich + ","")
                .replace(" + Sandwich","None") + "\n";
        orderInfo += "Bonus : " + bonus + "\n";
        orderInfo += "Price : " + sandwich.getPrice() + "\n";
        orderInfo += paymentMessage + "\n";
        return orderInfo;
    }
}
