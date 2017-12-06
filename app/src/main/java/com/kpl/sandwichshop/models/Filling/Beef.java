package com.kpl.sandwichshop.models.Filling;

import com.kpl.sandwichshop.StaticKeys;
import com.kpl.sandwichshop.R;

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
    public int getDrawable() { return R.drawable.beef; }

    @Override
    public String getCategory() {
        return StaticKeys.categoryMeat;
    }
}
