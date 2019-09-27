package ar.edu.ub.pcsw.designPatterns.exercises.logger;

public abstract class Logger
{
    void log(LogMessage message)
    {
        this.log(message.toString());
    }

    abstract void log(String message);
}
