package com.kpl.sandwichshop.filter;

import com.kpl.sandwichshop.StaticKeys;
import com.kpl.sandwichshop.models.filling.Filling;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zaki on 4/12/17.
 */

public class CondimentFilter implements FilterFilling {

    @Override
    public List<Filling> meetCriteria(List<Filling> fillings) {
        List<Filling> condiment = new ArrayList<>();
        for (Filling filling : fillings) {
            if (filling.getCategory().contentEquals(StaticKeys.CATEGORY_CONDIMENT)) {
                condiment.add(filling);
            }
        }
        return condiment;
    }

}

