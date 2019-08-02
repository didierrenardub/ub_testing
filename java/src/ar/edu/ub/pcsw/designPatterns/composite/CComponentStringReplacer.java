package ar.edu.ub.pcsw.designPatterns.composite;

public class CComponentStringReplacer extends CComponent
{
    public CComponentStringReplacer()
    {
        super("string-replacer");
    }

    @Override
    public String run(String[] args)
    {
        if(args.length < 1)
        {
            return "";
        }
        else if(args.length < 3)
        {
            return args[0];
        }

        return args[0].replace(args[1], args[2]);
    }
}
