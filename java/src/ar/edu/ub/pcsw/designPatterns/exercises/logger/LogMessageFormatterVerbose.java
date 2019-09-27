package ar.edu.ub.pcsw.designPatterns.exercises.logger;

public class LogMessageFormatterVerbose implements LogMessageFormatter
{
    @Override
    public String format(LogMessage message)
    {
        StringBuilder result = new StringBuilder();

        result.append(">".repeat(80)).append("\n");
        for(LogInfo info : message.info())
        {
            result.append("> ").append(info.key()).append(": ").append(info.data()).append("\n");
        }
        result.append(message.text()).append("\n").append("<".repeat(80)).append("\n");

        return result.toString();
    }
}
