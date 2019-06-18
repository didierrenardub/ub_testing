package ar.edu.ub.testing.Discount;

import java.util.ArrayList;
import java.util.Collection;

public class CDiscount
{
    public CDiscount(String name, String description, boolean cumulative, Collection<IDiscountEffect> effects, IDiscountCondition condition)
    {
        this.m_name = name;
        this.m_description = description;
        this.m_cumulative = cumulative;
        this.m_effects = new ArrayList<>(effects);
        this.m_condition = condition;
    }

    public CDiscount(String name, String description, boolean cumulative, Collection<IDiscountEffect> effects)
    {
        this(name, description, cumulative, effects, null);
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

    public boolean cumulative()
    {
        // TODO: implement
        return false;
    }

    public Collection<IDiscountEffect> effects()
    {
        // TODO: implement
        return null;
    }

    public IDiscountCondition condition()
    {
        // TODO: implement
        return null;
    }

    public boolean applicable(CShoppingBasket basket, CShoppingBasketItem item)
    {
        // TODO: implement
        return false;
    }

    public Collection<CDiscountInstance> apply(CShoppingBasket basket)
    {
        // TODO: implement
        return null;
    }

    private String m_name;
    private String m_description;
    private boolean m_cumulative;
    private Collection<IDiscountEffect> m_effects;
    private IDiscountCondition m_condition;
}
