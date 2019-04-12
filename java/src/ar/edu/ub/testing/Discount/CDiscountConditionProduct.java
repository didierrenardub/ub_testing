package ar.edu.ub.testing.Discount;

public class CDiscountConditionProduct implements IDiscountCondition
{
    public CDiscountConditionProduct(CProduct product)
    {
        this.m_product = product;
    }

    @Override
    public boolean met(CShoppingBasket basket, CShoppingBasketItem item)
    {
        // TODO: implement
        return false;
    }

    private CProduct m_product;
}
