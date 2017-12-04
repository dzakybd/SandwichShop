package com.kpl.sandwichshop.models.Filling;

import com.kpl.sandwichshop.FillingCategory;
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
        return 1500;
    }

    @Override
    public int getDrawable() {
        return R.drawable.mayones;
    }

    @Override
    public String getCategory() {
        return FillingCategory.condiment;
    }
}
