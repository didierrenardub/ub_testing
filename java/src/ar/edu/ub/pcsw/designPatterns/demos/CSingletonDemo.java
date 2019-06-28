package ar.edu.ub.pcsw.designPatterns.demos;

import ar.edu.ub.pcsw.designPatterns.singleton.Singleton;

public class CSingletonDemo implements IDemo
{
    @Override
    public String name()
    {
        return "Singleton demo";
    }

    @Override
    public void run()
    {
        Singleton s = Singleton.instance();
        System.out.println("\t\tSingleton says:");
        s.sayHello();
        System.out.println("\t\tTrying to get another singleton, but there'll be no luck:");
        s = Singleton.instance();
        s.sayHello();
    }
}
