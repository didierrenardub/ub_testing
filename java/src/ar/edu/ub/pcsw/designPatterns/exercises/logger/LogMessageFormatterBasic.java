package ar.edu.ub.pcsw.designPatterns.exercises.logger;

public class LogMessageFormatterBasic implements LogMessageFormatter
{
    @Override
    public String format(LogMessage message)
    {
        StringBuilder result = new StringBuilder();
        for(LogInfo info : message.info())
        {
            result.append(info.data()).append(" ");
        }
        result.append(message.text());
        return result.toString();
    }
}
