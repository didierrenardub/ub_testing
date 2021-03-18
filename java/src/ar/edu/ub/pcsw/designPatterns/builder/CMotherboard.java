package ar.edu.ub.pcsw.designPatterns.builder;

public class CMotherboard
{
    public CMotherboard(String brand, String chipset)
    {
        this.m_brand = brand;
        this.m_chipset = chipset;
    }

    public String brand()
    {
        return this.m_brand;
    }

    public String chipset()
    {
        return this.m_chipset;
    }

    @Override
    public String toString()
    {
        return this.brand() + " " + this.chipset();
    }

    private String m_brand;
    private String m_chipset;
}
