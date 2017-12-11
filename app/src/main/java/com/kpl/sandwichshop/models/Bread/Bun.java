package com.kpl.sandwichshop.models.Bread;

import com.kpl.sandwichshop.R;

/**
 * Created by zaki on 4/12/17.
 */

public class Bun extends Bread {

    @Override
    public String getName() {
        return "Bun bread";
    }

    @Override
    public int getPrice() {
        return 2000;
    }

    @Override
    public int getDrawable() {
        return R.drawable.bread_bun;
    }

}
