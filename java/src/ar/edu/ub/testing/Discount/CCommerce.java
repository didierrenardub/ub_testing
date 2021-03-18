package ar.edu.ub.testing.Discount;

import java.util.ArrayList;
import java.util.Collection;

public class CCommerce extends CNameableBase
{
    public CCommerce(String name)
    {
        super(name);
        this.m_products = new ArrayList<>();
    }
    
    public void addProduct(CProductInstance productInstace)
    {
    	// TODO: implement
    }
    
    public void addProducts(Collection<CProductInstance> productInstances)
    {
    	// TODO: implement
    }

    public Collection<CProductInstance> branded(CBrand brand)
    {
        // TODO: implement
        return null;
    }

    public Collection<CProductInstance> tagged(String tag)
    {
        // TODO: implement
        return null;
    }
    
    public CProductInstance product(String withName)
    {
    	// TODO: implement
    	return null;
    }

    private Collection<CProductInstance> m_products;
}
