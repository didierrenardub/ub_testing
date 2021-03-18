package ar.edu.ub.pcsw.designPatterns.command;

import java.util.ArrayList;

public class CCalculatorCommandAdd implements ICalculatorCommand
{
    @Override
    public String name()
    {
        return "add";
    }

    @Override
    public int run(ArrayList<Integer> args)
    {
        int result = 0;
        for(int arg : args)
        {
            result += arg;
        }
        return result;
    }
}
