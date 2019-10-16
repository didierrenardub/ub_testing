package ar.edu.ub.pcsw.designPatterns.exercises.string;

public abstract class StringExtenderBase implements StringExtender
{
    public StringExtenderBase(StringExtender extend)
    {
        this.m_toExtend = extend;
    }

    protected StringExtender m_toExtend;
}
