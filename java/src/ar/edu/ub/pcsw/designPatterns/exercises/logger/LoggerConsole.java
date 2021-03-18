package ar.edu.ub.pcsw.designPatterns.exercises.logger;

public class LoggerConsole extends Logger
{
    @Override
    public void log(String message)
    {
        System.out.println(message);
    }
}
