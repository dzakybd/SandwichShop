package com.kpl.sandwichshop.strategy;

import com.kpl.sandwichshop.StaticKeys;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Ilham Aulia Majid on 28-Nov-17.
 */

public class CardPayment implements PaymentMethod {

    private String cardNumber;
    private String cvcCode;
    private String expiredDate;

    public CardPayment(String cardnumber, String cvccode, String expireddate){
        this.cardNumber=cardnumber;
        this.cvcCode=cvccode;
        this.expiredDate=expireddate;
    }

    @Override
    public String processPayment(int price) {

        if(cardNumber.length() != 16){
            return StaticKeys.CARD_INVALID;
        }

        if(!cvcCode.contentEquals(cardNumber.substring(cardNumber.length() - 3))){
            return StaticKeys.CARD_WRONG_CVC;
        }

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy", Locale.US);
        Date dateexp = null;
        Date datenow = null;
        try {
            dateexp = sdf.parse(expiredDate);
            datenow = sdf.parse(cal.get(Calendar.MONTH)+"/"+(cal.get(Calendar.YEAR)));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(dateexp != null && dateexp.compareTo(datenow) < 0){
            return StaticKeys.CARD_EXPIRED;
        }

        return price +" paid with card";
    }
}
