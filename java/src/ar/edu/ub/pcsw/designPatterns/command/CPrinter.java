package ar.edu.ub.pcsw.designPatterns.command;

public class CPrinter
{
    public CPrinter(IPrintStrategy strategy)
    {
        this.m_strategy = strategy;
    }

    public void setStrategy(IPrintStrategy strategy)
    {
        this.m_strategy = strategy;
    }

    public void print(String what)
    {
        this.m_strategy.run(what);
    }

    private IPrintStrategy m_strategy;
}
