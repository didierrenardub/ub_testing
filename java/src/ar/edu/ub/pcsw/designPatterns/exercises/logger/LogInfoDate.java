package ar.edu.ub.pcsw.designPatterns.exercises.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogInfoDate implements LogInfo
{
    public LogInfoDate(Date date)
    {
        this.m_date = date;
    }

    public LogInfoDate()
    {
        this(new Date());
    }

    @Override
    public String key()
    {
        return "date";
    }

    @Override
    public String data()
    {
        return new SimpleDateFormat("YYYY-MM-dd").format(this.m_date);
    }

    private Date m_date;
}
