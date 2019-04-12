package ar.edu.ub.testing.Discount;

import java.util.ArrayList;
import java.util.Collection;

public abstract class CDiscountConditionMultiple implements IDiscountCondition
{
    public CDiscountConditionMultiple(Collection<IDiscountCondition> conditions)
    {
        this.m_conditions = new ArrayList<>(conditions);
    }

    public void add(IDiscountCondition condition)
    {
        // TODO: implement
    }

    private Collection<IDiscountCondition> m_conditions;
}
