package ar.edu.ub.pcsw.designPatterns.command;

import java.util.ArrayList;

public class CCalculator
{
    public CCalculator()
    {
        this.m_commands = new ArrayList<>();
    }

    public void addCommand(ICalculatorCommand command)
    {
        this.m_commands.add(command);
    }

    public int run(String cmd, ArrayList<Integer> args)
    {
        for(ICalculatorCommand command : this.m_commands)
        {
            if(command.name().equalsIgnoreCase(cmd))
            {
                return command.run(args);
            }
        }
        return -1;
    }

    private ArrayList<ICalculatorCommand> m_commands;
}
