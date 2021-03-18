package ar.edu.ub.pcsw.designPatterns.composite;

public class CMessageProcessor extends CComponent
{
    public CMessageProcessor()
    {
        super("message-processor");
    }

    @Override
    public String run(String[] args)
    {
        if(args.length < 2)
        {
            return "";
        }

        if(args[0].equalsIgnoreCase("encode") && this.component("message-encoder") != null)
        {
            return this.component("message-encoder").run(new String[] { args[1] });
        }
        else if(args[0].equalsIgnoreCase("decode") && this.component("message-decoder") != null)
        {
            return this.component("message-decoder").run(new String[] { args[1] });
        }

        return args[1];
    }

    public String encode(String what)
    {
        return this.run(new String[] { "encode", what });
    }

    public String decode(String what)
    {
        return this.run(new String[] { "decode", what });
    }
}
