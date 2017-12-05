package com.kpl.sandwichshop.singleton;

/**
 * Created by zaki on 4/12/17.
 */

public class Discount {

    private int price;
    private String code;

    private Discount() {
    }

    private static Discount discount = new Discount();

    public static Discount getDiscount() {
        return discount;
    }

    public int getPrice() {
        return price;
    }


    public void setPrice(int price) {
        this.price = price;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
