package com.kpl.sandwichshop.models.filling;

import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.StaticKeys;

/**
 * Created by zaki on 4/12/17.
 */

public class Beef extends Filling {
    @Override
    public String getName() {
        return "Beef";
    }

    @Override
    public int getPrice() {
        return 3000;
    }

    @Override
    public int getDrawable() {
        return R.drawable.beef;
    }

    @Override
    public String getCategory() {
        return StaticKeys.CATEGORY_MEAT;
    }
}
