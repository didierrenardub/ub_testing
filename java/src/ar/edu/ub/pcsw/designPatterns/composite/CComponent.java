package ar.edu.ub.pcsw.designPatterns.composite;

import java.util.ArrayList;

public abstract class CComponent
{
    public CComponent(String name)
    {
        this.m_name = name;
        this.m_childComponents = new ArrayList<>();
    }

    public abstract String run(String[] args);

    public String name()
    {
        return this.m_name;
    }

    public void addComponent(CComponent component)
    {
        this.m_childComponents.add(component);
    }

    public CComponent component(String name)
    {
        for(CComponent component : this.m_childComponents)
        {
            if(component.name().equalsIgnoreCase(name))
            {
                return component;
            }
        }

        return null;
    }

    private String m_name;
    private ArrayList<CComponent> m_childComponents;
}
