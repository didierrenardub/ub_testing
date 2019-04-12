package ar.edu.ub.testing.Discount;

public class CDiscountConditionTag implements IDiscountCondition
{
    public CDiscountConditionTag(String tag)
    {
        this.m_tag = tag;
    }

    @Override
    public boolean met(CShoppingBasket basket, CShoppingBasketItem item)
    {
        // TODO: implement
        return false;
    }

    private String m_tag;
}
