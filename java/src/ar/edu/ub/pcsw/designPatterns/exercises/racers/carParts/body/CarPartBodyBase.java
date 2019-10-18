package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.body;

public abstract class CarPartBodyBase implements CarPartBody
{
    public CarPartBodyBase(int antiquity, float quality)
    {
        this.m_quality = quality;
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

    private float m_quality;
    private int m_antiquity;
}
