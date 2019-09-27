package ar.edu.ub.pcsw.designPatterns.exercises.logger;

import ar.edu.ub.IMain;

import java.util.Arrays;

public class LoggerMain extends IMain
{
    @Override
    public void run(String[] args)
    {
        Logger l = new LoggerMultiple(Arrays.asList(new LoggerConsole(), new LoggerFile("logger.log")));
        LogMessageProvider lmp = new LogMessageProvider();

        LogMessageFormatter simple = new LogMessageFormatterSimple();
        LogMessageFormatter verbose = new LogMessageFormatterVerbose();
        l.log(lmp.date().time().text("Log started").get());
        l.log(lmp.date().time().file().line().text("Students, start detecting design patterns!").get());
        l.log(lmp.date().time().file().line().format(simple).text("Have you spotted any yet?").get());
        l.log(lmp.time().line().format(verbose).text("You should already have...").get());
        l.log(lmp.date().time().file().line().format(verbose).text("Exam is coming").get());
    }
}
