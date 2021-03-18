package ar.edu.ub.pcsw.designPatterns.demos;

import ar.edu.ub.pcsw.designPatterns.command.*;

import java.util.ArrayList;

public class CCommandDemo extends CDemoBase
{
    @Override
    public String name()
    {
        return "Command demo";
    }

    @Override
    public void run()
    {
        CCalculator c = new CCalculator();
        c.addCommand(new CCalculatorCommandAdd());
        c.addCommand(new CCalculatorCommandSubtract());
        c.addCommand(new CCalculatorCommandMultiply());
        c.addCommand(new CCalculatorCommandDivide());

        System.out.println("Enter a command to be executed:");
        String[] args = this.readString().split(" ");
        ArrayList<Integer> iargs = new ArrayList<>();
        for(int i = 1; i < args.length; i++)
        {
            iargs.add(Integer.parseInt(args[i]));
        }

        System.out.println("Result: " + c.run(args[0], iargs));
    }
}
