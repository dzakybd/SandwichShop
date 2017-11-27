package com.kpl.sandwichshop.strategy;

/**
 * Created by Ilham Aulia Majid on 28-Nov-17.
 */

public class MoneyDiscount implements DiscountType {

    @Override
    public int getFinalPrice(int price, int value) {
        int finalPrice = (price - value);
        return (finalPrice > 0) ? finalPrice : 0;
    }

}
