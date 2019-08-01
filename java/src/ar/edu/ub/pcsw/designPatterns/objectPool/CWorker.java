package ar.edu.ub.pcsw.designPatterns.objectPool;

public class CWorker
{
    public CWorker(String name)
    {
        this.m_name = name;
    }

    public String name()
    {
        return this.m_name;
    }

    private String m_name;
}
