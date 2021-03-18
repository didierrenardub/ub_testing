package ar.edu.ub.pcsw.designPatterns.builder;

public class CRAM
{
    public CRAM(String brand, int capacity, int speed)
    {
        this.m_brand = brand;
        this.m_capacity = capacity;
        this.m_speed = speed;
    }

    public String brand()
    {
        return this.m_brand;
    }

    public int capacity()
    {
        return this.m_capacity;
    }

    public int speed()
    {
        return this.m_speed;
    }

    @Override
    public String toString()
    {
        return this.brand() + " " + this.capacity() + "GB @" + this.speed() + "Mhz";
    }

    private String m_brand;
    private int m_capacity;
    private int m_speed;
}
