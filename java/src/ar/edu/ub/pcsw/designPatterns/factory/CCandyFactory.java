package ar.edu.ub.pcsw.designPatterns.factory;

import java.util.ArrayList;

public class CCandyFactory
{
    public CCandyFactory()
    {
        this.m_candies = new ArrayList<>();
    }

    public void addCandy(ICandy candy)
    {
        this.m_candies.add(candy);
    }

    public ICandy create(String candyName, float price)
    {
        for(ICandy candy : this.m_candies)
        {
            if(candy.name().equalsIgnoreCase(candyName))
            {
                ICandy ret = candy.cloneCandy();
                ret.setPrice(price);
                return ret;
            }
        }

        return null;
    }

    private ArrayList<ICandy> m_candies;
}
