package com.kpl.sandwichshop.strategy;

import com.kpl.sandwichshop.StaticKeys;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Ilham Aulia Majid on 28-Nov-17.
 */

public class CardPayment implements PaymentMethod {

    String cardnumber;
    String cvccode;
    String expireddate;

    public CardPayment(String cardnumber, String cvccode, String expireddate){
        this.cardnumber=cardnumber;
        this.cvccode=cvccode;
        this.expireddate=expireddate;
    }

    @Override
    public String processPayment(int price) {

        if(cardnumber.length() != 16){
            return StaticKeys.CARD_INVALID;
        }

        if(!cvccode.contentEquals(cardnumber.substring(cardnumber.length() - 3))){
            return StaticKeys.CARD_WRONG_CVC;
        }

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
        Date dateexp = null;
        Date datenow = null;
        try {
            dateexp = sdf.parse(expireddate);
            datenow = sdf.parse(cal.get(Calendar.MONTH)+"/"+(cal.get(Calendar.YEAR)));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        assert dateexp != null;
        if(dateexp.compareTo(datenow) < 0){
            return StaticKeys.CARD_EXPIRED;
        }

        return price +" paid with card";
    }
}
