package ar.edu.ub.pcsw.designPatterns.exercises.logger;

public class LogInfoEmpty implements LogInfo
{
    @Override
    public String key()
    {
        return "<EMPTY>";
    }

    @Override
    public String data()
    {
        return "";
    }
}
