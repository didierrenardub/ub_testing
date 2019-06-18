package ar.edu.ub.testing.Discount;

public class CDiscountEffectAmount implements IDiscountEffect
{
    public CDiscountEffectAmount(float amount, int maxCount)
    {
        this.m_amount = amount;
        this.m_maxCount = maxCount;
    }

    public float amount()
    {
        // TODO: implement
        return 0.0f;
    }

    public int maxCount()
    {
        // TODO: implement
        return -1;
    }

    @Override
    public CDiscountInstance apply(CShoppingBasket basket, CShoppingBasketItem item)
    {
        // TODO: implement
        return null;
    }

    private float m_amount;
    private int m_maxCount;
}
