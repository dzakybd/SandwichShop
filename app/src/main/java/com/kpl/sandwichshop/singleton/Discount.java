package com.kpl.sandwichshop.singleton;

import com.kpl.sandwichshop.builder.Sandwich;
import com.kpl.sandwichshop.strategy.DiscountType;
import com.kpl.sandwichshop.strategy.NoDiscount;

/**
 * Created by Ilham Aulia Majid on 28-Nov-17.
 */

public class Discount {

    private static final Discount ourInstance = new Discount();

    private int price;
    private String voucherCode;
    private DiscountType type;
    private int value;

    private Discount() {
    }

    public static Discount getInstance() {
        return ourInstance;
    }

    public void setSandwich(Sandwich sandwich) {
        this.price = sandwich.getPrice();
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
        //this.type =
        //this.value =
    }

    public void removeVoucherCode() {
        this.voucherCode = "";
        this.type = new NoDiscount();
        this.value = 0;
    }

    public int getFinalPrice() {
        return type.getFinalPrice(price, value);
    }

}
