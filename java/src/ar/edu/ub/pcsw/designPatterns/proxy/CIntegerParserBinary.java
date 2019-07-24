package ar.edu.ub.pcsw.designPatterns.proxy;

public class CIntegerParserBinary implements IIntegerParser
{
    @Override
    public int parse(String from)
    {
        int result = 0;
        for(int i = 0; i < from.length(); i++)
        {
            result = result * 2 + (int)(from.charAt(i) - '0');
        }
        return result;
    }
}
