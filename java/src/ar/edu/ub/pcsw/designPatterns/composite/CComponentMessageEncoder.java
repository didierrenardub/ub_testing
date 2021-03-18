package ar.edu.ub.pcsw.designPatterns.composite;

public class CComponentMessageEncoder extends CComponent
{
    public CComponentMessageEncoder()
    {
        super("message-encoder");
    }

    @Override
    public String run(String[] args)
    {
        if(args.length < 1)
        {
            return "";
        }

        String partial = args[0];
        if(this.component("string-replacer") != null)
        {
            partial = this.component("string-replacer").run(new String[] { partial, "A", "xVx" });
            partial = this.component("string-replacer").run(new String[] { partial, "E", "xWx" });
            partial = this.component("string-replacer").run(new String[] { partial, "I", "xXx" });
            partial = this.component("string-replacer").run(new String[] { partial, "O", "xYx" });
            partial = this.component("string-replacer").run(new String[] { partial, "U", "xZx" });
            partial = this.component("string-replacer").run(new String[] { partial, "a", "XvX" });
            partial = this.component("string-replacer").run(new String[] { partial, "e", "XwX" });
            partial = this.component("string-replacer").run(new String[] { partial, "i", "XxX" });
            partial = this.component("string-replacer").run(new String[] { partial, "o", "XyX" });
            partial = this.component("string-replacer").run(new String[] { partial, "u", "XzX" });
        }

        if(this.component("case-inverter") != null)
        {
            partial = this.component("case-inverter").run(new String[] { partial });
        }

        if(this.component("string-reverser") != null)
        {
            partial = this.component("string-reverser").run(new String[] { partial });
        }

        if(this.component("string-to-hexa") != null)
        {
            partial = this.component("string-to-hexa").run(new String[] { partial });
        }

        if(this.component("string-flipper") != null)
        {
            partial = this.component("string-flipper").run(new String[] { partial });
        }

        return partial;
    }
}
