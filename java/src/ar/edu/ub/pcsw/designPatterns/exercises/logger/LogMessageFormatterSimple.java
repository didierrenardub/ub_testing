package ar.edu.ub.pcsw.designPatterns.exercises.logger;

public class LogMessageFormatterSimple implements LogMessageFormatter
{
    @Override
    public String format(LogMessage message)
    {
        StringBuilder result = new StringBuilder();

        LogInfo info = message.info("date");
        if(!info.data().isEmpty())
        {
            result.append("[").append(info.data());
        }

        info = message.info("time");
        if(!info.data().isEmpty())
        {
            result.append((result.length() == 0)? "[" : " ").append(info.data());
        }

        info = message.info("file");
        if(!info.data().isEmpty())
        {
            result.append((result.length() == 0)? "[" : " | ").append(info.data());
        }

        info = message.info("line");
        if(!info.data().isEmpty())
        {
            if(result.length() == 0)
            {
                result.append("[???.java");
            }
            else if(result.indexOf("|") == -1)
            {
                result.append(" | ???.java");
            }
            result.append(":").append(info.data());
        }

        if(result.length() > 0)
        {
            result.append("] ");
        }

        result.append(message.text());

        return result.toString();
    }
}
