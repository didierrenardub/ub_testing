package ar.edu.ub.pcsw.designPatterns.decorator;

import java.util.ArrayList;
import java.util.List;

public abstract class CStringFilterBase implements IStringFilter
{
    public CStringFilterBase(IStringFilter other)
    {
        this.m_other = other;
    }

    @Override
    public String filter(String source)
    {
        String result = source;

        if(this.m_other != null)
        {
            result = this.m_other.filter(result);
        }

        return this.apply(result);
    }

    private IStringFilter m_other;
}
