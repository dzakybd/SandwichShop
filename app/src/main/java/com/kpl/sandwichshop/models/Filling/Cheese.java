package com.kpl.sandwichshop.models.Filling;

import com.kpl.sandwichshop.StaticKeys;
import com.kpl.sandwichshop.R;

/**
 * Created by zaki on 4/12/17.
 */

public class Cheese extends Filling {
    @Override
    public String getName() {
        return "Cheese";
    }

    @Override
    public int getPrice() {
        return 1500;
    }

    @Override
    public int getDrawable() {
        return R.drawable.keju;
    }

    @Override
    public String getCategory() {
        return StaticKeys.categoryCondiment;
    }
}
