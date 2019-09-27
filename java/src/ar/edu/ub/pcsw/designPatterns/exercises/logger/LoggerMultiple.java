package ar.edu.ub.pcsw.designPatterns.exercises.logger;

import java.util.List;

public class LoggerMultiple extends Logger
{
    public LoggerMultiple(List<Logger> loggers)
    {
        this.m_loggers = loggers;
    }

    void add(Logger logger)
    {
        if(!this.m_loggers.contains(logger))
        {
            this.m_loggers.add(logger);
        }
    }

    @Override
    public void log(String message)
    {
        for(Logger logger : this.m_loggers)
        {
            logger.log(message);
        }
    }

    private List<Logger> m_loggers;
}
