package ar.edu.ub.pcsw.designPatterns.exercises.string;

public class StringExtenderUnderscore extends StringExtenderBase
{
    public StringExtenderUnderscore(StringExtender extend, int underscores)
    {
        super(extend);
        this.m_underscores = underscores;
    }

    public StringExtenderUnderscore(StringExtender extend)
    {
        this(extend, 2);
    }

    @Override
    public String toString()
    {
        String result = "";
        for(int i = 0; i < this.m_underscores; i++)
        {
            result += '_';
        }
        result += m_toExtend.toString();
        for(int i = 0; i < this.m_underscores; i++)
        {
            result += '_';
        }
        return result;
    }

    protected int m_underscores;
}
