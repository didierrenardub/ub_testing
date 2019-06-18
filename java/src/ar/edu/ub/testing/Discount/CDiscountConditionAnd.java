package ar.edu.ub.testing.Discount;

import java.util.Collection;

public class CDiscountConditionAnd extends CDiscountConditionMultiple
{
    public CDiscountConditionAnd(Collection<IDiscountCondition> conditions)
    {
        super(conditions);
    }

    @Override
    public boolean met(CShoppingBasket basket, CShoppingBasketItem item)
    {
        // TODO: implement
        return false;
    }
}
