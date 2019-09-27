package ar.edu.ub.pcsw.designPatterns.exercises.logger;

public class LogInfoPlain implements LogInfo
{
    public LogInfoPlain(String key, String data)
    {
        this.m_key = key;
        this.m_data = data;
    }

    @Override
    public String key()
    {
        return this.m_key;
    }

    @Override
    public String data()
    {
        return this.m_data;
    }

    private String m_key;
    private String m_data;
}
