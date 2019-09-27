package ar.edu.ub.pcsw.designPatterns.exercises.logger;

import java.util.ArrayList;

public class LogMessage
{
    public LogMessage(LogMessageFormatter formatter)
    {
        this.m_text = "";
        this.m_info = new ArrayList<>();
        this.m_empty = new LogInfoEmpty();
        this.m_formatter = formatter;
    }

    public LogMessage()
    {
        this(new LogMessageFormatterBasic());
    }

    public void setFormatter(LogMessageFormatter formatter)
    {
        this.m_formatter = formatter;
    }

    public void setText(String text)
    {
        this.m_text = text;
    }

    public String text()
    {
        return this.m_text;
    }

    public void addInfo(LogInfo info)
    {
        this.m_info.add(info);
    }

    public LogInfo info(String withKey)
    {
        for(LogInfo info : this.m_info)
        {
            if(info.key().equalsIgnoreCase(withKey))
            {
                return info;
            }
        }

        return this.m_empty;
    }

    public ArrayList<LogInfo> info()
    {
        return this.m_info;
    }

    @Override
    public String toString()
    {
        return this.m_formatter.format(this);
    }

    protected String m_text;
    protected ArrayList<LogInfo> m_info;
    protected LogInfoEmpty m_empty;
    protected LogMessageFormatter m_formatter;
}
