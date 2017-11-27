package com.kpl.sandwichshop.singleton;

/**
 * Created by Ilham Aulia Majid on 28-Nov-17.
 */

public class Discount {

    private static final Discount ourInstance = new Discount();

    private String voucherCode;

    private Discount() {
    }

    public static Discount getInstance() {
        return ourInstance;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public void removeVoucherCode(){
        this.voucherCode = null;
    }
}
