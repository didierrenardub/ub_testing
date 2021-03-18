package ar.edu.ub;

import java.util.Scanner;

public abstract class IMain
{
    public IMain()
    {
    }

    protected int userInput(int min, int max)
    {
        Scanner s = new Scanner(System.in);

        int input = min - 1;

        while(input < min || input > max)
        {
            try
            {
                input = s.nextInt();
            }
            catch(Exception e)
            {
                s.nextLine();
            }
            finally
            {

                if(input < min || input > max)
                {
                    System.out.println("Invalid input, try again:");
                }
            }
        }

        return input;
    }

    public abstract void run(String[] args);
}
