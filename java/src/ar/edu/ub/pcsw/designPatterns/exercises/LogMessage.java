package ar.edu.ub.pcsw.designPatterns.exercises;

import java.util.HashMap;

public class LogMessage
{
    public LogMessage()
    {
        this.m_text = "";
        this.m_info = new HashMap<>();
        this.m_empty = new LogInfoEmpty();
    }

    void setText(String text)
    {
        this.m_text = text;
    }

    String text()
    {
        return this.m_text;
    }

    void addInfo(LogInfo info)
    {
        this.m_info.put(info.key(), info);
    }

    LogInfo info(String withKey)
    {
        if(this.m_info.containsKey(withKey))
        {
            return this.m_info.get(withKey);
        }

        return this.m_empty;
    }

    private String m_text;
    private HashMap<String, LogInfo> m_info;
    private LogInfoEmpty m_empty;
}
