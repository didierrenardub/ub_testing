package ar.edu.ub.pcsw.designPatterns.proxy;

public class CIntegerParserProxy implements IIntegerParser
{
    public void setBinaryParser(IIntegerParser parser)
    {
        this.m_binary = parser;
    }

    public void setDecimalParser(IIntegerParser parser)
    {
        this.m_decimal = parser;
    }

    public void setHexaParser(IIntegerParser parser)
    {
        this.m_hexa = parser;
    }

    @Override
    public int parse(String from)
    {
        if(from.charAt(0) == 'b')
        {
            return this.m_binary.parse(from.substring(1));
        }
        else if(from.charAt(0) == 'h')
        {
            return this.m_hexa.parse(from.substring(1));
        }

        return this.m_decimal.parse(from);
    }

    private IIntegerParser m_binary;
    private IIntegerParser m_decimal;
    private IIntegerParser m_hexa;
}
