package ar.edu.ub.pcsw.designPatterns.exercises.logger;

public class LogInfoLine implements LogInfo
{
    public LogInfoLine()
    {
    }

    @Override
    public String key()
    {
        return "line";
    }

    @Override
    public String data()
    {
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        for(StackTraceElement element : trace)
        {
            if(!element.getFileName().contains("Log"))
            {
                return "" + element.getLineNumber();
            }
        }
        return "" + trace[0].getLineNumber();
    }
}
