package ar.edu.ub.testing.Discount;

import java.util.ArrayList;
import java.util.Collection;

public class CShoppingBasket
{
    public CShoppingBasket()
    {
        this.m_items = new ArrayList<>();
        this.m_discounts = new ArrayList<>();
    }

    public Collection<CShoppingBasketItem> items()
    {
        // TODO: implement
        return null;
    }

    public Collection<CDiscountInstance> discounts()
    {
        // TODO: implement
        return null;
    }

    public void addItem(CShoppingBasketItem item)
    {
        // TODO: implement
    }
    
    public void addItems(Collection<CShoppingBasketItem> items)
    {
    	// TODO: implement
    }

    public void removeItem(CShoppingBasketItem item)
    {
        // TODO: implement
    }

    public float total()
    {
        // TODO: implement
        return 0.0f;
    }

    public float totalDiscount()
    {
        // TODO: implement
        return 0.0f;
    }

    public float net()
    {
        // TODO: implement
        return 0.0f;
    }

    public void applyDiscount(CDiscount discount)
    {
        // TODO: implement
    }

    public boolean hasDiscountOnProduct(CProduct product)
    {
        // TODO: implement
        return false;
    }

    public boolean hasDiscountOnBrand(CBrand brand)
    {
        // TODO: implement
        return false;
    }

    public String ticket()
    {
        // TODO: implement
        return null;
    }

    private Collection<CShoppingBasketItem> m_items;
    private Collection<CDiscountInstance> m_discounts;
}
