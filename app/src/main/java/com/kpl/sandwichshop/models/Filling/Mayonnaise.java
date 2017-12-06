package com.kpl.sandwichshop.models.Filling;

import com.kpl.sandwichshop.StaticKeys;
import com.kpl.sandwichshop.R;

/**
 * Created by zaki on 4/12/17.
 */

public class Mayonnaise extends Filling {
    @Override
    public String getName() {
        return "Mayonnaise";
    }

    @Override
    public int getPrice() {
        return 1000;
    }

    @Override
    public int getDrawable() {
        return R.drawable.mayonnaise;
    }

    @Override
    public String getCategory() { return StaticKeys.categoryCondiment; }
}
