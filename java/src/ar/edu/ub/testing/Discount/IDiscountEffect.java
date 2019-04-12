package ar.edu.ub.testing.Discount;

public interface IDiscountEffect
{
    CDiscountInstance apply(CShoppingBasket basket, CShoppingBasketItem item);
}
