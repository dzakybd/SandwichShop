package com.kpl.sandwichshop.models.Filling;

import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.StaticKeys;

/**
 * Created by Hendry on 12/6/2017.
 */

public class Salt extends Filling {
    @Override
    public String getName() {
        return "Salt";
    }

    @Override
    public int getPrice() {
        return 500;
    }

    @Override
    public int getDrawable() {
        return R.drawable.salt;
    }

    @Override
    public String getCategory() {
        return StaticKeys.CATEGORY_CONDIMENT;
    }
}
