package com.kpl.sandwichshop.models.Filling;

import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.StaticKeys;

/**
 * Created by Hendry on 12/5/2017.
 */

public class Onion extends Filling {
    @Override
    public String getName() {
        return "Onion";
    }

    @Override
    public int getPrice() {
        return 500;
    }

    @Override
    public int getDrawable() {
        return R.drawable.onion;
    }

    @Override
    public String getCategory() {
        return StaticKeys.CATEGORY_VEGETABLE;
    }
}
