package ar.edu.ub.pcsw.designPatterns.exercises;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogInfoTime implements LogInfo
{
    public LogInfoTime(Date date)
    {
        this.m_date = date;
    }

    public LogInfoTime()
    {
        this(new Date());
    }

    @Override
    public String key()
    {
        return "time";
    }

    @Override
    public String data()
    {
        return new SimpleDateFormat("HH:mm:ss").format(this.m_date);
    }

    private Date m_date;
}
