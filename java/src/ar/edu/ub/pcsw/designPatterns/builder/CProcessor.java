package ar.edu.ub.pcsw.designPatterns.builder;

public class CProcessor
{
    public CProcessor(String brand, String model, int speed)
    {
        this.m_brand = brand;
        this.m_model = model;
        this.m_speed = speed;
    }

    public String brand()
    {
        return this.m_brand;
    }

    public String model()
    {
        return this.m_model;
    }

    public int speed()
    {
        return this.m_speed;
    }

    @Override
    public String toString()
    {
        return this.brand() + " " + this.model() + " @" + this.speed() + "Mhz";
    }

    private String m_brand;
    private String m_model;
    private int m_speed;
}
