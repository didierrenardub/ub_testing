package ar.edu.ub.pcsw.designPatterns.composite;

public class CComponentMessageDecoder extends CComponent
{
    public CComponentMessageDecoder()
    {
        super("message-decoder");
    }

    @Override
    public String run(String[] args)
    {
        if(args.length < 1)
        {
            return "";
        }

        String partial = args[0];
        if(this.component("string-flipper") != null)
        {
            partial = this.component("string-flipper").run(new String[] { partial });
        }

        if(this.component("string-from-hexa") != null)
        {
            partial = this.component("string-from-hexa").run(new String[] { partial });
        }

        if(this.component("string-reverser") != null)
        {
            partial = this.component("string-reverser").run(new String[] { partial });
        }

        if(this.component("case-inverter") != null)
        {
            partial = this.component("case-inverter").run(new String[] { partial });
        }

        if(this.component("string-replacer") != null)
        {
            partial = this.component("string-replacer").run(new String[] { partial, "xVx", "A" });
            partial = this.component("string-replacer").run(new String[] { partial, "xWx", "E" });
            partial = this.component("string-replacer").run(new String[] { partial, "xXx", "I" });
            partial = this.component("string-replacer").run(new String[] { partial, "xYx", "O" });
            partial = this.component("string-replacer").run(new String[] { partial, "xZx", "U" });
            partial = this.component("string-replacer").run(new String[] { partial, "XvX", "a" });
            partial = this.component("string-replacer").run(new String[] { partial, "XwX", "e" });
            partial = this.component("string-replacer").run(new String[] { partial, "XxX", "i" });
            partial = this.component("string-replacer").run(new String[] { partial, "XyX", "o" });
            partial = this.component("string-replacer").run(new String[] { partial, "XzX", "u" });
        }

        return partial;
    }
}
