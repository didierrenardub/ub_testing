package ar.edu.ub.pcsw.designPatterns.composite;

public class CComponentStringFlipper extends CComponent
{
    public CComponentStringFlipper()
    {
        super("string-flipper");
    }

    @Override
    public String run(String[] args)
    {
        if(args.length < 1)
        {
            return "";
        }

        String[] splitted = args[0].split(" ");
        String result = "";
        for(int i = 1; i < splitted.length; i += 2)
        {
            result += splitted[i] + " " + splitted[i - 1] + " ";
        }
        if((splitted.length % 2) != 0)
        {
            result += splitted[splitted.length - 1];
        }
        return result.trim();
    }
}
