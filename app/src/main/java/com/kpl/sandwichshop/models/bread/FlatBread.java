package com.kpl.sandwichshop.models.bread;

import com.kpl.sandwichshop.R;

/**
 * Created by zaki on 4/12/17.
 */

public class FlatBread extends Bread {

    @Override
    public String getName() {
        return "Flat bread";
    }

    @Override
    public int getPrice() {
        return 1500;
    }

    @Override
    public int getDrawable() {
        return R.drawable.bread_flat;
    }

}
