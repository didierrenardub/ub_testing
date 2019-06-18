package ar.edu.ub.testing.Discount;

import java.util.ArrayList;
import java.util.Collection;

public class CDataManager
{
    public CDataManager()
    {
        this.m_brands = new ArrayList<>();
        this.m_products = new ArrayList<>();
        this.m_payments = new ArrayList<>();
        this.m_commerces = new ArrayList<>();
        this.m_discount = new ArrayList<>();
    }

    public Collection<CBrand> brands()
    {
        // TODO: implement
        return null;
    }

    public Collection<CProduct> products()
    {
        // TODO: implement
        return null;
    }

    public Collection<CPayment> payments()
    {
        // TODO: implement
        return null;
    }

    public Collection<CCommerce> commerces()
    {
        // TODO: implement
        return null;
    }
    
    public Collection<CDiscount> discounts()
    {
    	// TODO: implement
    	return null;
    }

    public void add(CBrand brand)
    {
        // TODO: implement
    }

    public void addBrands(Collection<CBrand> brands)
    {
        // TODO: implement
    }

    public void add(CProduct product)
    {
        // TODO: implement
    }

    public void addProducts(Collection<CProduct> products)
    {
        // TODO: implement
    }

    public void add(CPayment payment)
    {
        // TODO: implement
    }

    public void addPayments(Collection<CPayment> payments)
    {
        // TODO: implement
    }

    public void add(CCommerce commerce)
    {
        // TODO: implement
    }

    public void addCommerces(Collection<CCommerce> commerces)
    {
        // TODO: implement
    }
    
    public void add(CDiscount discount)
    {
    	// TODO: implement
    }
    
    public void addDiscounts(Collection<CDiscount> discounts)
    {
    	// TODO: implement
    }

    public CBrand brand(String withName)
    {
        // TODO: implement
        return null;
    }

    public CProduct product(String withName)
    {
        // TODO: implement
        return null;
    }

    public CPayment payment(String withName)
    {
        // TODO: implement
        return null;
    }

    public CCommerce commerce(String withName)
    {
        // TODO: implement
        return null;
    }
    
    public CDiscount discount(String withName)
    {
    	// TODO: implement
    	return null;
    }

    private Collection<CBrand> m_brands;
    private Collection<CProduct> m_products;
    private Collection<CPayment> m_payments;
    private Collection<CCommerce> m_commerces;
    private Collection<CDiscount> m_discount;
}
