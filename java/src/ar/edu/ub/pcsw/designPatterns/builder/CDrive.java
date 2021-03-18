package ar.edu.ub.pcsw.designPatterns.builder;

public class CDrive
{
    public CDrive(String brand, String bus, int capacity)
    {
        this.m_brand = brand;
        this.m_bus = bus;
        this.m_capacity = capacity;
    }

    public String brand()
    {
        return this.m_brand;
    }

    public String bus()
    {
        return this.m_bus;
    }

    public int capacity()
    {
        return this.m_capacity;
    }

    @Override
    public String toString()
    {
        return this.brand() + " " + this.bus() + " " + this.capacity() + "GB";
    }

    private String m_brand;
    private String m_bus;
    private int m_capacity;
}
