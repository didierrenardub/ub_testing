package ar.edu.ub.pcsw.designPatterns.exercises.racers;

public class TrackPart
{
    public enum GroundType
    {
        Road,
        Soil,
        Sand,
        Grass
    }

    public enum SectionType
    {
        Straight,
        SlightCurve,
        Curve,
        ClosedCurve,
        UTurn
    }

    public enum Steep
    {
        Flat,
        SlightDown,
        SlightUp,
        BigDown,
        BigUp
    }

    public TrackPart(GroundType type, SectionType section, Steep steep)
    {
        this.m_ground = type;
        this.m_section = section;
        this.m_steep = steep;
    }

    public GroundType ground()
    {
        return this.m_ground;
    }

    public SectionType section()
    {
        return this.m_section;
    }

    public Steep steep()
    {
        return this.m_steep;
    }

    @Override
    public String toString()
    {
        return "[[" + this.m_ground.name() + "," + this.m_section.name() + "," + this.m_steep.name() + "]]";
    }

    private GroundType m_ground;
    private SectionType m_section;
    private Steep m_steep;
}
