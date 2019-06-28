package ar.edu.ub.pcsw;

import ar.edu.ub.IMain;
import ar.edu.ub.pcsw.designPatterns.demos.CNullObjectDemo;

public class CPCSWMain extends IMain
{
    @Override
    public void run(String[] args)
    {
        System.out.println("Choose an action:\n1 - Null Object demo");

        switch(this.userInput(1, 1))
        {
            case 1:
                new CNullObjectDemo().run();
            break;
        }
    }
}
