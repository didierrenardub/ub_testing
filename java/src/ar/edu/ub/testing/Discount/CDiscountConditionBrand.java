package ar.edu.ub.testing.Discount;

public class CDiscountConditionBrand implements IDiscountCondition
{
    public CDiscountConditionBrand(CBrand brand)
    {
        this.m_brand = brand;
    }

    @Override
    public boolean met(CShoppingBasket basket, CShoppingBasketItem item)
    {
        // TODO: implement
        return false;
    }

    private CBrand m_brand;
}
