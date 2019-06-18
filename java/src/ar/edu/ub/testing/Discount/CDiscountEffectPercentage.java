package ar.edu.ub.testing.Discount;

public class CDiscountEffectPercentage implements IDiscountEffect
{
    public CDiscountEffectPercentage(float percentage, float maxAmount)
    {
        this.m_percentage = percentage;
        this.m_maxAmount = maxAmount;
    }

    public CDiscountEffectPercentage(float percentage)
    {
        this(percentage, -1.0f);
    }

    public float percentage()
    {
        // TODO: implement
        return 0.0f;
    }

    public float maxAmount()
    {
        // TODO: implement
        return -1.0f;
    }

    @Override
    public CDiscountInstance apply(CShoppingBasket basket, CShoppingBasketItem item)
    {
        // TODO: implement
        return null;
    }

    private float m_percentage;
    private float m_maxAmount;
}
