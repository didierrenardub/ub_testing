package ar.edu.ub.pcsw.designPatterns.builder;

public class CPCBuilder
{
    public CPCBuilder()
    {
        this.m_building = null;
    }

    public CPCBuilder setCase(String brand, int power)
    {
        this.checkCreatePc();
        this.m_building.setCase(new CCase(brand, power));
        return this;
    }

    public CPCBuilder setMotherboard(String brand, String chipset)
    {
        this.checkCreatePc();
        this.m_building.setMotherboard(new CMotherboard(brand, chipset));
        return this;
    }

    public CPCBuilder setProcessor(String brand, String model, int speed)
    {
        this.checkCreatePc();
        this.m_building.setProcessor(new CProcessor(brand, model, speed));
        return this;
    }

    public CPCBuilder setRAM(String brand, int capacity, int speed)
    {
        this.checkCreatePc();
        this.m_building.setRAM(new CRAM(brand, capacity, speed));
        return this;
    }

    public CPCBuilder setDrive(String brand, String bus, int capacity)
    {
        this.checkCreatePc();
        this.m_building.setDrive(new CDrive(brand, bus, capacity));
        return this;
    }

    public CPC build()
    {
        CPC temp = this.m_building;
        this.m_building = null;
        return temp;
    }

    private void checkCreatePc()
    {
        if(this.m_building == null)
        {
            this.m_building = new CPC();
        }
    }

    private CPC m_building;
}
