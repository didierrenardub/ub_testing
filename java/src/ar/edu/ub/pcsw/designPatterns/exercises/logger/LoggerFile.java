package ar.edu.ub.pcsw.designPatterns.exercises.logger;

import java.io.FileWriter;
import java.io.IOException;

public class LoggerFile extends Logger
{
    public LoggerFile(String fileName)
    {
        this.m_fileName = fileName;
    }

    @Override
    public void log(String message)
    {
        try
        {
            FileWriter fw = new FileWriter(this.m_fileName, true);
            fw.write(message + "\n");
            fw.close();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private String m_fileName;
}
