package ar.edu.ub.testing.Discount;

import java.util.Collection;

public class CDiscountConditionOr extends CDiscountConditionMultiple
{
    public CDiscountConditionOr(Collection<IDiscountCondition> conditions)
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
