package ar.edu.ub.pcsw.designPatterns.factory;

public abstract class CCandyBase implements ICandy
{
    public CCandyBase(float price)
    {
        this.m_price = price;
    }

    @Override
    public float price()
    {
        return this.m_price;
    }

    @Override
    public String toString()
    {
        return this.name() + " (" + description() + "), priced " + this.price();
    }

    private float m_price;
}
