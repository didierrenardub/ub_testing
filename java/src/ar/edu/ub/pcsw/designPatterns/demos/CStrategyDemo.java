package ar.edu.ub.pcsw.designPatterns.demos;

import ar.edu.ub.pcsw.designPatterns.strategy.CPrintStrategyKanji;
import ar.edu.ub.pcsw.designPatterns.strategy.CPrintStrategyCommon;
import ar.edu.ub.pcsw.designPatterns.strategy.CPrinter;
import ar.edu.ub.pcsw.designPatterns.strategy.CPrinterStrategyMatrix;

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
        System.out.println("Get ready...");
        try
        {
            Thread.sleep(5000);
        }
        catch(Exception e)
        {
        }
        p.setStrategy(new CPrinterStrategyMatrix());
        p.print(s);
    }
}
