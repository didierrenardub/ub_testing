package ar.edu.ub.pcsw.designPatterns.exercises.string;

public class StringExtenderString implements StringExtender
{
    public StringExtenderString(String extend)
    {
        this.m_toExtend = extend;
    }

    @Override
    public String toString()
    {
        return m_toExtend;
    }

    private String m_toExtend;
}
