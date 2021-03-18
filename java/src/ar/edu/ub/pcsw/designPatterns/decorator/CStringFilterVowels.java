package ar.edu.ub.pcsw.designPatterns.decorator;

import java.util.ArrayList;
import java.util.List;

public class CStringFilterVowels extends CStringFilterBase
{
    public CStringFilterVowels(IStringFilter other)
    {
        super(other);
    }

    @Override
    public String apply(String source)
    {
        String result = "";

        for(int i = 0; i < source.length(); i++)
        {
            if(!"AEIOUaeiou".contains("" + source.charAt(i)))
            {
                result += source.charAt(i);
            }
        }

        return result;
    }
}
