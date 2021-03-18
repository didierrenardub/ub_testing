package ar.edu.ub.pcsw.designPatterns.exercises.string;

public class StringExtenderStar extends StringExtenderBase
{
    public StringExtenderStar(StringExtender extend, int stars)
    {
        super(extend);
        this.m_stars = stars;
    }

    public StringExtenderStar(StringExtender extend)
    {
        this(extend, 2);
    }

    @Override
    public String toString()
    {
        String result = "";
        for(int i = 0; i < this.m_stars; i++)
        {
            result += '*';
        }
        result += m_toExtend.toString();
        for(int i = 0; i < this.m_stars; i++)
        {
            result += '*';
        }
        return result;
    }

    protected int m_stars;
}
