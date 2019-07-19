package ar.edu.ub.pcsw.designPatterns.demos;

import ar.edu.ub.pcsw.designPatterns.factory.CCandyFactory;
import ar.edu.ub.pcsw.designPatterns.factory.ICandy;

public class CFactoryDemo extends CDemoBase
{
    @Override
    public String name()
    {
        return "Factory demo";
    }

    @Override
    public void run()
    {
        CCandyFactory factory = new CCandyFactory();
        String i = "";
        System.out.println("Enter a candy name to create one, type 'exit' to quit:");
        while(!(i = this.readString()).equalsIgnoreCase("exit"))
        {
            System.out.print("Enter a price for " + i + ": ");
            ICandy c = factory.create(i, this.readFloat());
            if(c != null)
            {
                System.out.println("Here you go: " + c.toString());
            }
            else
            {
                System.out.println("No such candy named " + i);
            }
            System.out.println("Enter a candy name to create one, type 'exit' to quit:");
        }
    }
}
