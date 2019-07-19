package ar.edu.ub.pcsw.designPatterns.factory;

public class CCandyFactory
{
    public CCandyFactory()
    {
    }

    public ICandy create(String candyName, float price)
    {
        if(candyName.equalsIgnoreCase("Lipo Superacido"))
        {
            return new CCandyLipoSuperacido(price);
        }
        else if(candyName.equalsIgnoreCase("Sugus"))
        {
            return new CCandySugus(price);
        }
        else if(candyName.equalsIgnoreCase("Butter Toffee"))
        {
            return new CCandyButterToffee(price);
        }

        return null;
    }
}
