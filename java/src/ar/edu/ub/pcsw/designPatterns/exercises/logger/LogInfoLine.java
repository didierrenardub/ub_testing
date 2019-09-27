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
            String fn = element.getFileName();
            if((!fn.contains("Log") || fn.equalsIgnoreCase("LoggerMain.java")) && !fn.contains("Thread"))
            {
                return "" + element.getLineNumber();
            }
        }
        return "" + trace[0].getLineNumber();
    }
}
