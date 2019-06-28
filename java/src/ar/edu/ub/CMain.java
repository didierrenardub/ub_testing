package ar.edu.ub;

import ar.edu.ub.pcsw.CPCSWMain;
import ar.edu.ub.testing.CTestingMain;

public class CMain extends IMain
{
    public void run(String[] args)
    {
        System.out.println("Choose an action:\n1 - PCSW\n2 - Testing");

        switch(this.userInput(1, 2))
        {
            case 1:
                new CPCSWMain().run(null);
            break;

            case 2:
                new CTestingMain().run(null);
            break;
        }
    }

    public static void main(String[] args)
    {
        new CMain().run(args);
    }
}
