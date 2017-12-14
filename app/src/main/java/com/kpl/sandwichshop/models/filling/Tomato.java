package com.kpl.sandwichshop.models.filling;

import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.StaticKeys;

/**
 * Created by zaki on 4/12/17.
 */

public class Tomato extends Filling {
    @Override
    public String getName() {
        return "Tomato";
    }

    @Override
    public int getPrice() {
        return 500;
    }

    @Override
    public int getDrawable() {
        return R.drawable.tomato;
    }

    @Override
    public String getCategory() {
        return StaticKeys.CATEGORY_VEGETABLE;
    }
}
