package ar.edu.ub;

import ar.edu.ub.pcsw.CPCSWExercisesMain;
import ar.edu.ub.pcsw.CPCSWMain;
import ar.edu.ub.testing.CTestingMain;

import java.util.Arrays;
import java.util.List;

public class CMain extends IMain
{
    public void run(String[] args)
    {
        List<IMain> mains = Arrays.asList(
                new CPCSWMain(),
                new CPCSWExercisesMain(),
                new CTestingMain()
        );

        StringBuilder prompt = new StringBuilder();
        prompt.append("Choose an action:");

        int i = 1;
        for(IMain main : mains)
        {
            prompt.append("\n").append(i).append(" - ").append(main.toString());
            i++;
        }

        System.out.println(prompt);
        mains.get(this.userInput(1, mains.size() - 1) - 1).run(args);
    }

    public static void main(String[] args)
    {
        new CMain().run(args);
    }
}
