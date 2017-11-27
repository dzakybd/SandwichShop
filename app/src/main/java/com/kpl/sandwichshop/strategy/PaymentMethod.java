package com.kpl.sandwichshop.strategy;

/**
 * Created by Ilham Aulia Majid on 27-Nov-17.
 */

public interface PaymentMethod {

    public void processPayment(int price, int value);

}
