package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.direction;

public abstract class CarPartDirectionBase implements CarPartDirection
{
    public CarPartDirectionBase(int antiquity, float quality)
    {
        this.m_antiquity = antiquity;
        this.m_quality = quality;
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
