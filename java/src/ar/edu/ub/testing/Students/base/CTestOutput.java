package ar.edu.ub.testing.Students.base;

public class CTestOutput
{
    public CTestOutput(String text, int grade)
    {
        m_text = text;
        m_grade = grade;
    }

    public CTestOutput(String text)
    {
        this(text, -1);
    }

    public String text()
    {
        return m_text;
    }

    public int grade()
    {
        return m_grade;
    }

    private String m_text;
    private int m_grade;
}
