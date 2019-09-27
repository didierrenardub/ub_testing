package ar.edu.ub.pcsw.designPatterns.exercises.logger;

public class LogInfoFile implements LogInfo
{
    public LogInfoFile()
    {
    }

    @Override
    public String key()
    {
        return "file";
    }

    @Override
    public String data()
    {
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        for(StackTraceElement element : trace)
        {
            if(!element.getFileName().contains("Log"))
            {
                return element.getFileName();
            }
        }
        return trace[0].getFileName();
    }
}
