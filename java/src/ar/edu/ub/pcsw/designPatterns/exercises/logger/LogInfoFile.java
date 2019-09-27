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
            String fn = element.getFileName();
            if((!fn.contains("Log") || fn.equalsIgnoreCase("LoggerMain.java")) && !fn.contains("Thread"))
            {
                return fn;
            }
        }
        return trace[0].getFileName();
    }
}
