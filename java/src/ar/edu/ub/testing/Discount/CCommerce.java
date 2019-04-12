package ar.edu.ub.testing.Discount;

import java.util.ArrayList;
import java.util.Collection;

public class CCommerce
{
    public CCommerce(String name)
    {
        this.m_name = name;
        this.m_products = new ArrayList<>();
    }

    public String name()
    {
        // TODO: implement
        return null;
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

    private String m_name;
    private Collection<CProductInstance> m_products;
}
