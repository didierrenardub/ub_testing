package ar.edu.ub.pcsw.designPatterns.composite;

public class CComponentStringFromHexa extends CComponent
{
    public CComponentStringFromHexa()
    {
        super("string-from-hexa");
    }

    @Override
    public String run(String[] args)
    {
        if(args.length < 1)
        {
            return "";
        }

        String result = "";
        for(String s : args[0].split(" "))
        {
            result += (char)Integer.parseInt(s,16);
        }
        return result;
    }
}
