package ar.edu.ub.pcsw.designPatterns.factory;

public class CCandyLipoSuperacido extends CCandyBase
{
    public CCandyLipoSuperacido(float price)
    {
        super(price);
    }

    @Override
    public String name()
    {
        return "Lipo Superacido";
    }

    @Override
    public String description()
    {
        return "A sour candy with a lot of crunchy sugar";
    }

    @Override
    public String flavor()
    {
        return "Sour";
    }
}
