package ar.edu.ub.pcsw;

import ar.edu.ub.IMain;
import ar.edu.ub.pcsw.designPatterns.exercises.logger.LoggerMain;
import ar.edu.ub.pcsw.designPatterns.exercises.string.StringExtenderMain;
import ar.edu.ub.pcsw.designPatterns.exercises.threads.ThreadsMain;

import java.util.Arrays;
import java.util.List;

public class CPCSWExercisesMain extends IMain
{
    @Override
    public void run(String[] args)
    {
        List<IMain> exercises = Arrays.asList(
                new LoggerMain(),
                new StringExtenderMain(),
                new ThreadsMain()
        );

        StringBuilder prompt = new StringBuilder();
        prompt.append("Choose an action:");

        int i = 1;
        for(IMain ex : exercises)
        {
            prompt.append("\n").append(i).append(" - ").append(ex.toString());
            i++;
        }

        System.out.println(prompt);

        exercises.get(this.userInput(1, exercises.size()) - 1).run(args);
    }
}
