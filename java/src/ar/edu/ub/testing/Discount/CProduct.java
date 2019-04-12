package ar.edu.ub.testing.Discount;

import java.util.ArrayList;
import java.util.Collection;

public class CProduct
{
    public CProduct(CBrand brand, Collection<String> tags, String name, String description)
    {
        this.m_brand = brand;
        this.m_tags = new ArrayList<>(tags);
        this.m_name = name;
        this.m_description = description;
    }

    public CBrand brand()
    {
        // TODO: implement
        return null;
    }

    public Collection<String> tags()
    {
        // TODO: implement
        return null;
    }

    public String name()
    {
        // TODO: implement
        return null;
    }

    public String description()
    {
        // TODO: implement
        return null;
    }

    public String fullName()
    {
        // TODO: implement
        return null;
    }

    public boolean hasTag(String tag)
    {
        // TODO: implement
        return false;
    }

    private CBrand m_brand;
    private Collection<String> m_tags;
    private String m_name;
    private String m_description;
}