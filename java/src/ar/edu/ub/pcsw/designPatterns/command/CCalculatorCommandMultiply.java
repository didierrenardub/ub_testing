package ar.edu.ub.pcsw.designPatterns.command;

import java.util.ArrayList;

public class CCalculatorCommandMultiply implements ICalculatorCommand
{
    @Override
    public String name()
    {
        return "mul";
    }

    @Override
    public int run(ArrayList<Integer> args)
    {
        int result = 1;
        for(int arg : args)
        {
            result *= arg;
        }
        return result;
    }
}
