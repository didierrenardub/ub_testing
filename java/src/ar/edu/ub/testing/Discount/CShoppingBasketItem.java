package ar.edu.ub.testing.Discount;

public class CShoppingBasketItem
{
    public CShoppingBasketItem(CPayment payment, CProductInstance productInstance, int count)
    {
        this.m_payment = payment;
        this.m_productInstance = productInstance;
        this.m_count = count;
    }

    public CPayment payment()
    {
        // TODO: implement
        return null;
    }

    public CProductInstance productInstance()
    {
        // TODO: implement
        return null;
    }

    public int count()
    {
        // TODO: implement
        return -1;
    }

    public float total()
    {
        // TODO implement
        return 0.0f;
    }

    private CPayment m_payment;
    private CProductInstance m_productInstance;
    private int m_count;
}
