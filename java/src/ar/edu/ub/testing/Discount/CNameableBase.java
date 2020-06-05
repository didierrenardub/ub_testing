package ar.edu.ub.testing.Discount;

public class CNameableBase implements INameable
{
    public CNameableBase(String name)
    {
        this.m_name = name;
    }

    @Override
    public String name()
    {
        return this.m_name;
    }

    private String m_name;
}
