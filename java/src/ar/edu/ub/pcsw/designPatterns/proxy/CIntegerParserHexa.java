package ar.edu.ub.pcsw.designPatterns.proxy;

public class CIntegerParserHexa implements IIntegerParser
{
    @Override
    public int parse(String from)
    {
        int result = 0;
        for(int i = 0; i < from.length(); i++)
        {
            char c = from.toUpperCase().charAt(i);
            if(c >= '0' && c <= '9')
            {
                c -= '0';
            }
            else if(c >= 'A' && c <= 'F')
            {
                c -= 'A' + 10;
            }
            result = result * 16 + c;
        }
        return result;
    }
}
