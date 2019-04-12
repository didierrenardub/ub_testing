package ar.edu.ub.testing.Discount;

public class CDiscountConditionMinimumTotal implements IDiscountCondition
{
    public CDiscountConditionMinimumTotal(float minimum)
    {
        this.m_minimum = minimum;
    }

    @Override
    public boolean met(CShoppingBasket basket, CShoppingBasketItem item)
    {
        // TODO: implement
        return false;
    }

    private float m_minimum;
}
