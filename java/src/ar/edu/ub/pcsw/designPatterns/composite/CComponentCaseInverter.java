package ar.edu.ub.pcsw.designPatterns.composite;

public class CComponentCaseInverter extends CComponent
{
    public CComponentCaseInverter()
    {
        super("case-inverter");
    }

    @Override
    public String run(String[] args)
    {
        if(args.length < 1)
        {
            return "";
        }

        String result = "";
        for(char c : args[0].toCharArray())
        {
            if(Character.isUpperCase(c))
            {
                result += Character.toLowerCase(c);
            }
            else
            {
                result += Character.toUpperCase(c);
            }
        }
        return result;
    }
}
