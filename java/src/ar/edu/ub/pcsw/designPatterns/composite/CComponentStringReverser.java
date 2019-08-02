package ar.edu.ub.pcsw.designPatterns.composite;

public class CComponentStringReverser extends CComponent
{
    public CComponentStringReverser()
    {
        super("string-reverser");
    }

    @Override
    public String run(String[] args)
    {
        if(args.length < 1)
        {
            return "";
        }

        String result = "";
        for(int i = args[0].length() - 1; i >= 0; i--)
        {
            result += args[0].charAt(i);
        }
        return result;
    }
}
