package com.kpl.sandwichshop.strategy;

import com.kpl.sandwichshop.builder.Sandwich;

/**
 * Created by Ilham Aulia Majid on 27-Nov-17.
 */

public interface PaymentMethod {

    public void processPayment(int price, int value);

}
