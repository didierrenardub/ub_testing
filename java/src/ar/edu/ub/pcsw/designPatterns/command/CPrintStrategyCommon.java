package ar.edu.ub.pcsw.designPatterns.command;

public class CPrintStrategyCommon implements IPrintStrategy
{
    @Override
    public void run(String what)
    {
        System.out.println(what);
    }
}
