package com.kpl.sandwichshop.models.Bread;

import com.kpl.sandwichshop.R;

/**
 * Created by zaki on 4/12/17.
 */

public class Long extends Bread {
    @Override
    public String getName() {
        return "Long bread";
    }

    @Override
    public int getPrice() {
        return 2500;
    }

    @Override
    public int getDrawable() {
        return R.drawable.bread_long;
    }
}
