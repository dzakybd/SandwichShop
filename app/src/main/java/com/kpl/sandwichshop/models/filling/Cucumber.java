package com.kpl.sandwichshop.models.filling;

import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.StaticKeys;

/**
 * Created by Hendry on 12/5/2017.
 */

public class Cucumber extends Filling {
    @Override
    public String getName() {
        return "Cucumber";
    }

    @Override
    public int getPrice() {
        return 500;
    }

    @Override
    public int getDrawable() {
        return R.drawable.cucumber;
    }

    @Override
    public String getCategory() {
        return StaticKeys.CATEGORY_VEGETABLE;
    }
}
