package ar.edu.ub.pcsw.designPatterns.factory;

public class CCandyButterToffee extends CCandyBase
{
    public CCandyButterToffee(float price)
    {
        super(price);
    }

    @Override
    public String name()
    {
        return "Butter Toffee";
    }

    @Override
    public String description()
    {
        return "A kinda hard chewable candy";
    }

    @Override
    public String flavor()
    {
        return "Sweet milk";
    }
}
