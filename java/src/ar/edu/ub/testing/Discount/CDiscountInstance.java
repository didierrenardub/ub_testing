package ar.edu.ub.testing.Discount;

public class CDiscountInstance
{
    public CDiscountInstance(CDiscount discount, CProductInstance productInstance, float amount, String name)
    {
        this.m_discount = discount;
        this.m_productInstance = productInstance;
        this.m_amount = amount;
        this.m_name = name;
    }

    public CDiscount discount()
    {
        // TODO: implement
        return null;
    }

    public CProductInstance productInstance()
    {
        // TODO: implement
        return null;
    }

    public float amount()
    {
        // TODO: implement
        return 0.0f;
    }

    public String name()
    {
        // TODO: implement
        return null;
    }

    private CDiscount m_discount;
    private CProductInstance m_productInstance;
    private float m_amount;
    private String m_name;
}
