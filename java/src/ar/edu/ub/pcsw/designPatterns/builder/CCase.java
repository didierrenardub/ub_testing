package ar.edu.ub.pcsw.designPatterns.builder;

public class CCase
{
    public CCase(String brand, int power)
    {
        this.m_brand = brand;
        this.m_power = power;
    }

    public String brand()
    {
        return this.m_brand;
    }

    public int power()
    {
        return this.m_power;
    }

    @Override
    public String toString()
    {
        return this.brand() + " case @" + this.power() + "w";
    }

    private String m_brand;
    private int m_power;
}
