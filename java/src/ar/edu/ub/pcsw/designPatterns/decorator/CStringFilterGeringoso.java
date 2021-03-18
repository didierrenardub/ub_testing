package ar.edu.ub.pcsw.designPatterns.decorator;

public class CStringFilterGeringoso extends CStringFilterBase
{
    public CStringFilterGeringoso(IStringFilter other)
    {
        super(other);
    }

    @Override
    public String apply(String source)
    {
        String result = "";

        for(int i = 0; i < source.length(); i++)
        {
            if("AEIOUaeiou".contains("" + source.charAt(i)))
            {
                result += source.charAt(i) + "p";
            }
            result += source.charAt(i);
        }

        return result;
    }
}
