package ar.edu.ub.testing.Discount;

public class CDiscountConditionPayment implements IDiscountCondition
{
    public CDiscountConditionPayment(CPayment payment)
    {
        this.m_payment = payment;
    }

    @Override
    public boolean met(CShoppingBasket basket, CShoppingBasketItem item)
    {
        // TODO: implement
        return false;
    }

    private CPayment m_payment;
}
