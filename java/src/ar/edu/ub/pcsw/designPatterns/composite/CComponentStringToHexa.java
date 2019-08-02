package ar.edu.ub.pcsw.designPatterns.composite;

public class CComponentStringToHexa extends CComponent
{
    public CComponentStringToHexa()
    {
        super("string-to-hexa");
    }

    @Override
    public String run(String[] args)
    {
        if(args.length < 1)
        {
            return "";
        }

        String result = "";
        for(char s : args[0].toCharArray())
        {
            result += Integer.toString(s, 16) + " ";
        }
        return result.trim();
    }
}
