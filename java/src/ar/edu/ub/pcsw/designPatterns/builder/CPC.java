package ar.edu.ub.pcsw.designPatterns.builder;

public class CPC
{
    public CPC()
    {
    }

    public void setCase(CCase cas)
    {
        this.m_case = cas;
    }

    public void setMotherboard(CMotherboard motherboard)
    {
        this.m_motherboard = motherboard;
    }

    public void setProcessor(CProcessor processor)
    {
        this.m_processor = processor;
    }

    public void setRAM(CRAM ram)
    {
        this.m_ram = ram;
    }

    public void setDrive(CDrive drive)
    {
        this.m_drive = drive;
    }

    public CCase body()
    {
        return this.m_case;
    }

    public CMotherboard motherboard()
    {
        return this.m_motherboard;
    }

    public CProcessor processor()
    {
        return this.m_processor;
    }

    public CRAM ram()
    {
        return this.m_ram;
    }

    public CDrive drive()
    {
        return this.m_drive;
    }

    @Override
    public String toString()
    {
        return super.toString() + ":\n\t"
                + this.body().toString() + "\n\t"
                + this.motherboard().toString() + "\n\t"
                + this.processor().toString() + "\n\t"
                + this.ram().toString() + "\n\t"
                + this.drive().toString();
    }

    private CCase m_case;
    private CMotherboard m_motherboard;
    private CProcessor m_processor;
    private CRAM m_ram;
    private CDrive m_drive;
}
