package ar.edu.ub.pcsw.designPatterns.exercises.string;

import ar.edu.ub.IMain;
import ar.edu.ub.pcsw.designPatterns.exercises.string.StringExtender;
import ar.edu.ub.pcsw.designPatterns.exercises.string.StringExtenderStar;
import ar.edu.ub.pcsw.designPatterns.exercises.string.StringExtenderString;
import ar.edu.ub.pcsw.designPatterns.exercises.string.StringExtenderUnderscore;

public class StringExtenderMain extends IMain
{
    @Override
    public void run(String[] args)
    {
        StringExtender e = new StringExtenderString("If you are reading this is because you failed the exam");
        e = new StringExtenderUnderscore(e);
        e = new StringExtenderStar(e);
        System.out.println(e.toString());
        e = new StringExtenderUnderscore(e, 5);
        e = new StringExtenderStar(e, 1);
        e = new StringExtenderUppercase(e);
        System.out.println(e.toString());
    }
}
