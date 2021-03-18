package ar.edu.ub.pcsw.designPatterns.exercises.string;

public class StringExtenderUppercase extends StringExtenderBase
{
    public StringExtenderUppercase(StringExtender extend)
    {
        super(extend);
    }

    @Override
    public String toString()
    {
        return this.m_toExtend.toString().toUpperCase();
    }
}
