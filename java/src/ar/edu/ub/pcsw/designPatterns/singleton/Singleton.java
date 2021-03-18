package ar.edu.ub.pcsw.designPatterns.singleton;

public class Singleton
{
    public static Singleton instance()
    {
        if(Singleton.s_instance == null)
        {
            Singleton.s_instance = new Singleton();
        }
        return Singleton.s_instance;
    }

    private Singleton()
    {
    }

    public void sayHello()
    {
        System.out.println("\t\t\tHi, I'm " + this);
    }

    private static Singleton s_instance;
}
