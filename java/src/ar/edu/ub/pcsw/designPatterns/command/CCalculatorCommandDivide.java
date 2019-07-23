package ar.edu.ub.pcsw.designPatterns.command;

import java.util.ArrayList;

public class CCalculatorCommandDivide implements ICalculatorCommand
{
    @Override
    public String name()
    {
        return "div";
    }

    @Override
    public int run(ArrayList<Integer> args)
    {
        int result = 0;
        for(int i = 0; i < args.size(); i++)
        {
            if(i > 0)
            {
                result /= args.get(i);
            }
            else
            {
                result = args.get(i);
            }
        }
        return result;
    }
}
