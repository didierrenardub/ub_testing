package ar.edu.ub.pcsw.designPatterns.strategy;

public class CPrinterStrategyMatrix implements IPrintStrategy
{
    @Override
    public void run(String what)
    {
        for(int i = 0; i < what.length() + 1; i++)
        {
            what = what.substring(1) + what.charAt(0);
            for(StringBuilder line : new CPrintStrategyKanji().kanjirize(what))
            {
                for(int j = 0; j < line.length(); j++)
                {
                    System.out.print(line.charAt(j));
                    System.out.flush();
                    try
                    {
                        Thread.sleep(50);
                    }
                    catch(Exception e)
                    {
                    }
                }
                System.out.println();
            }
        }
    }
}
