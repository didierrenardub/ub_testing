package ar.edu.ub.pcsw.designPatterns.decorator;

import java.util.ArrayList;
import java.util.List;

public class CStringFilterUpperCase extends CStringFilterBase
{
    public CStringFilterUpperCase(IStringFilter other)
    {
        super(other);
    }

    @Override
    public String apply(String source)
    {
        String result = "";

        for(int i = 0; i < source.length(); i++)
        {
            if(!"ABCDEFGHIJKLMNÑOPQRSTUVWXYZ".contains("" + source.charAt(i)))
            {
                result += source.charAt(i);
            }
        }

        return result;
    }
}
