package ar.edu.ub.pcsw.designPatterns.demos;

import ar.edu.ub.pcsw.designPatterns.proxy.CIntegerParserBinary;
import ar.edu.ub.pcsw.designPatterns.proxy.CIntegerParserDecimal;
import ar.edu.ub.pcsw.designPatterns.proxy.CIntegerParserHexa;
import ar.edu.ub.pcsw.designPatterns.proxy.CIntegerParserProxy;

public class CProxyDemo extends CDemoBase
{
    @Override
    public String name()
    {
        return "Proxy demo";
    }

    @Override
    public void run()
    {
        CIntegerParserProxy p = new CIntegerParserProxy();
        p.setBinaryParser(new CIntegerParserBinary());
        p.setDecimalParser(new CIntegerParserDecimal());
        p.setHexaParser(new CIntegerParserHexa());

        System.out.println("Enter a number to be parsed (start it with 'b' for binary and 'h' for hexa):");
        System.out.println("The entered number value in decimal is: " + p.parse(this.readString()));
    }
}
