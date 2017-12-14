package com.kpl.sandwichshop.filter;

import com.kpl.sandwichshop.models.filling.Filling;

import java.util.List;

/**
 * Created by zaki on 4/12/17.
 */

public class OrCriteria implements FilterFilling {

    FilterFilling criteria;
    FilterFilling otherCriteria;

    public OrCriteria(FilterFilling criteria, FilterFilling otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Filling> meetCriteria(List<Filling> fillings) {
        List<Filling> firstCriteria =
                criteria.meetCriteria(fillings);
        List<Filling> nextCriteria =
                otherCriteria.meetCriteria(fillings);
        for (Filling ingredient : nextCriteria) {
            if (!firstCriteria.contains(ingredient)) {
                firstCriteria.add(ingredient);
            }
        }
        return firstCriteria;
    }

}