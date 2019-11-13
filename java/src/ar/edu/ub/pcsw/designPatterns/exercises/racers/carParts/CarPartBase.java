package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts;

public abstract class CarPartBase implements CarPart
{
    public CarPartBase(int antiquity, float quality)
    {
        this.m_antiquity = antiquity;
        this.m_quality = quality;
    }

    @Override
    public void setQuality(int quality)
    {
        this.m_quality = quality;
    }

    @Override
    public void setAntiquity(int antiquity)
    {
        this.m_antiquity = antiquity;
    }

    @Override
    public float quality()
    {
        return this.m_quality;
    }

    @Override
    public int antiquity()
    {
        return this.m_antiquity;
    }

    private int m_antiquity;
    private float m_quality;
}
