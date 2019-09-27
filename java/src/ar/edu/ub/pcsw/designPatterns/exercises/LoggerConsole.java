package ar.edu.ub.pcsw.designPatterns.exercises;

public class LoggerConsole implements Logger
{
    @Override
    public void log(LogMessage message)
    {
        System.out.println(message.text());
    }

    @Override
    public void log(String message)
    {
        System.out.println(message);
    }
}
