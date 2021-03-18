package ar.edu.ub.pcsw.designPatterns.decorator;

import java.util.ArrayList;
import java.util.List;

public class CStringFilterExpression extends CStringFilterBase
{
    public CStringFilterExpression(IStringFilter other, String expression)
    {
        super(other);
        this.m_expression = expression;
    }

    @Override
    public String apply(String source)
    {
        return source.replace(this.m_expression, "");
    }

    private String m_expression;
}
