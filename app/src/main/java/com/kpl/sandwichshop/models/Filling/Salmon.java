package com.kpl.sandwichshop.models.Filling;

import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.StaticKeys;

/**
 * Created by Hendry on 12/5/2017.
 */

public class Salmon extends Filling {
    @Override
    public String getName() { return "Salmon"; }

    @Override
    public int getPrice() { return 3000; }

    @Override
    public int getDrawable() { return R.drawable.salmon; }

    @Override
    public String getCategory() {
        return StaticKeys.categoryMeat;
    }
}
