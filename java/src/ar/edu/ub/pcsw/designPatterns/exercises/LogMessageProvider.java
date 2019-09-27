package ar.edu.ub.pcsw.designPatterns.exercises;

public class LogMessageProvider
{
    public LogMessageProvider()
    {
        this.m_current = new LogMessage();
    }

    public LogMessageProvider reset(LogMessage useThis)
    {
        this.m_current = useThis;
        return this;
    }

    public LogMessageProvider reset()
    {
        return this.reset(new LogMessage());
    }

    public LogMessageProvider date()
    {
        this.m_current.addInfo(new LogInfoDate());
        return this;
    }

    public LogMessageProvider time()
    {
        this.m_current.addInfo(new LogInfoTime());
        return this;
    }

    public LogMessageProvider add(LogInfo info)
    {
        this.m_current.addInfo(info);
        return this;
    }

    public LogMessage get()
    {
        LogMessage ret = this.m_current;
        this.reset();
        return ret;
    }

    private LogMessage m_current;
}
