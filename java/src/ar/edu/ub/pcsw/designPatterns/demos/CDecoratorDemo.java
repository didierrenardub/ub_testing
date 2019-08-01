package ar.edu.ub.pcsw.designPatterns.demos;

import ar.edu.ub.pcsw.designPatterns.decorator.*;

import java.util.Arrays;
import java.util.List;

public class CDecoratorDemo implements IDemo
{
    @Override
    public String name()
    {
        return "Decorator demo";
    }

    @Override
    public void run()
    {
        List<String> strings = Arrays.asList(
                "I like to SHOUT",
                "i don't like shouting",
                "River won the Libertadores 2019 final against Boca and they'll never forget it",
                "THErE iS A vERY HIDDeN MESSAGE HErE",
                "Lynyrd Skynyrd rules!",
                "Twisted Sister is very good as well",
                "shove it up your GLass"
            );

        this.runFilter("Just filtering out vowels:", new CStringFilterVowerls(null), strings);
        this.runFilter("Just filtering out 'is':", new CStringFilterExpression(null, "is"), strings);
        this.runFilter("Just filtering out uppercase letters:", new CStringFilterUpperCase(null), strings);
        this.runFilter("Making everything geringoso:", new CStringFilterGeringoso(null), strings);
        this.runFilter("Filtering vowels+uppercase:", new CStringFilterUpperCase(new CStringFilterVowerls(null)), strings);
        this.runFilter("Making it geringoso and filtering out 'epe':", new CStringFilterExpression(new CStringFilterGeringoso(null), "epe"), strings);
        this.runFilter("Applying ALL filters:", new CStringFilterVowerls(new CStringFilterUpperCase(new CStringFilterExpression(new CStringFilterGeringoso(null), "ipi"))), strings);
    }

    public void runFilter(String caption, IStringFilter f, List<String> where)
    {
        System.out.println("***************************************************");
        System.out.println(caption);
        for(String s : where)
        {
            System.out.println(f.filter(s));
        }
    }
}
