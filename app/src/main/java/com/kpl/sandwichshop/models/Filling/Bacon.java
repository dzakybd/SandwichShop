package com.kpl.sandwichshop.models.Filling;

import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.StaticKeys;

/**
 * Created by Hendry on 12/5/2017.
 */

public class Bacon extends Filling {
    @Override
    public String getName() {
        return "Bacon";
    }

    @Override
    public int getPrice() {
        return 2500;
    }

    @Override
    public int getDrawable() {
        return R.drawable.bacon;
    }

    @Override
    public String getCategory() {
        return StaticKeys.CATEGORY_MEAT;
    }
}
