package com.kpl.sandwichshop.strategy;

/**
 * Created by Ilham Aulia Majid on 28-Nov-17.
 */

public class PercentageDiscount implements DiscountType {

    @Override
    public int getFinalPrice(int price, int value) {
        int finalPrice = price * (100 - value) / 100;
        return finalPrice;
    }
}
