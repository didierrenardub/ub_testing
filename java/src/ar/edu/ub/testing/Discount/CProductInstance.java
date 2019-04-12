package ar.edu.ub.testing.Discount;

public class CProductInstance
{
    public CProductInstance(CProduct product, float price)
    {
        this.m_product = product;
        this.m_price = price;
    }

    private CProduct m_product;
    private float m_price;
}
