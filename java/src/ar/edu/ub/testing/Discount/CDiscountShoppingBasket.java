package ar.edu.ub.testing.Discount;

import java.util.Collection;

public class CDiscountShoppingBasket extends CDiscount
{
    public CDiscountShoppingBasket(String name, String description, boolean cumulative, Collection<IDiscountEffect> effects, IDiscountCondition condition)
    {
        super(name, description, cumulative, effects, condition);
    }

    public CDiscountShoppingBasket(String name, String description, boolean cumulative, Collection<IDiscountEffect> effects)
    {
        this(name, description, cumulative, effects, null);
    }

    @Override
    public boolean applicable(CShoppingBasket basket, CShoppingBasketItem item)
    {
        // TODO: implement
        return false;
    }

    @Override
    public Collection<CDiscountInstance> apply(CShoppingBasket basket)
    {
        // TODO: implement
        return null;
    }
}
