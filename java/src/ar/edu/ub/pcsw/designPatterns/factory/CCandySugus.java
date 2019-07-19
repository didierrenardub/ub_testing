package ar.edu.ub.pcsw.designPatterns.factory;

public class CCandySugus extends CCandyBase
{
    public CCandySugus(float price)
    {
        super(price);
    }

    @Override
    public String name()
    {
        return "Sugus";
    }

    @Override
    public String description()
    {
        return "Typical chewable candy with many flavors";
    }

    @Override
    public String flavor()
    {
        return "Many";
    }
}
