package com.kpl.sandwichshop.strategy;

/**
 * Created by Ilham Aulia Majid on 28-Nov-17.
 */

public class NoDiscount implements DiscountType {

    @Override
    public int getFinalPrice(int price, int value) {
        return price;
    }

}
