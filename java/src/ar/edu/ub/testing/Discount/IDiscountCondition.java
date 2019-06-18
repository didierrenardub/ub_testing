package ar.edu.ub.testing.Discount;

public interface IDiscountCondition
{
    boolean met(CShoppingBasket basket, CShoppingBasketItem item);
}
