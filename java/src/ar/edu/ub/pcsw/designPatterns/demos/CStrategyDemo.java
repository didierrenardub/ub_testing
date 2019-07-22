package ar.edu.ub.pcsw.designPatterns.demos;

import ar.edu.ub.pcsw.designPatterns.command.CPrintStrategyKanji;
import ar.edu.ub.pcsw.designPatterns.command.CPrintStrategyCommon;
import ar.edu.ub.pcsw.designPatterns.command.CPrinter;

public class CStrategyDemo extends CDemoBase
{
    @Override
    public String name()
    {
        return "Strategy demo";
    }

    @Override
    public void run()
    {
        CPrinter p = new CPrinter(new CPrintStrategyCommon());
        System.out.println("Enter a string to be printed:");
        String s = this.readString();
        p.print(s);
        p.setStrategy(new CPrintStrategyKanji());
        p.print(s);
    }
}
