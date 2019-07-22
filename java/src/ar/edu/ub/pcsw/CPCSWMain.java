package ar.edu.ub.pcsw;

import ar.edu.ub.IMain;
import ar.edu.ub.pcsw.designPatterns.demos.*;

import java.util.List;
import java.util.Arrays;

public class CPCSWMain extends IMain
{
    @Override
    public void run(String[] args)
    {
        List<IDemo> demos = Arrays.asList(
                new CNullObjectDemo()
                , new CSingletonDemo()
                , new CFactoryDemo()
                , new CBuilderDemo()
        );

        StringBuilder prompt = new StringBuilder();
        prompt.append("Choose an action:");

        int i = 1;
        for(IDemo demo : demos)
        {
            prompt.append("\n").append(i).append(" - ").append(demo.name());
            i++;
        }

        System.out.println(prompt);

        demos.get(this.userInput(1, demos.size()) - 1).run();
    }
}
