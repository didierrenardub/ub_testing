package ar.edu.ub.pcsw.designPatterns.exercises.logger;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class LogMessageJson extends LogMessage
{
    public LogMessageJson(LogMessageFormatter formatter, JSONObject fromJson)
    {
        super(formatter);
        this.m_translator = new LogMessageTranslator();
        this.m_json = fromJson;
    }

    public LogMessageJson(LogMessageFormatter formatter, LogMessage message)
    {
        super(formatter);
        this.m_translator = new LogMessageTranslator();
        this.m_json = this.m_translator.translate(message);
    }

    public LogMessageJson(LogMessageFormatter formatter)
    {
        super(formatter);
        this.m_translator = new LogMessageTranslator();
        this.m_json = this.m_translator.translate(new LogMessage());
    }

    public LogMessageJson(LogMessage message)
    {
        super();
        this.m_translator = new LogMessageTranslator();
        this.m_json = this.m_translator.translate(message);
    }

    public LogMessageJson(JSONObject json)
    {
        super();
        this.m_translator = new LogMessageTranslator();
        this.m_json = json;
    }

    public LogMessageJson()
    {
        super();
        this.m_translator = new LogMessageTranslator();
        this.m_json = this.m_translator.translate(new LogMessage());
    }

    public JSONObject json()
    {
        return this.m_json;
    }

    @Override
    public void setText(String text)
    {
        this.m_json.put(LogMessageTranslator.KEY_MESSAGE_TEXT, text);
    }

    @Override
    public String text()
    {
        return this.m_json.getString(LogMessageTranslator.KEY_MESSAGE_TEXT);
    }

    @Override
    public void addInfo(LogInfo info)
    {
        this.m_json.getJSONArray(LogMessageTranslator.KEY_MESSAGE_INFO).put(this.m_translator.translateInfo(info));
    }

    @Override
    public LogInfo info(String key)
    {
        JSONArray jinfo = this.m_json.getJSONArray(LogMessageTranslator.KEY_MESSAGE_INFO);
        for(int i = 0; i < jinfo.length(); i++)
        {
            if(jinfo.getJSONObject(i).getString(LogMessageTranslator.KEY_INFO_KEY).equalsIgnoreCase(key))
            {
                return this.m_translator.translateInfo(jinfo.getJSONObject(i));
            }
        }
        return this.m_empty;
    }

    @Override
    public ArrayList<LogInfo> info()
    {
        ArrayList<LogInfo> results = new ArrayList<>();
        JSONArray jinfo = this.m_json.getJSONArray(LogMessageTranslator.KEY_MESSAGE_INFO);
        for(int i = 0; i < jinfo.length(); i++)
        {
            results.add(this.m_translator.translateInfo(jinfo.getJSONObject(i)));
        }
        return results;
    }

    @Override
    public String toString()
    {
        return this.m_formatter.format(this.m_translator.translate(this.m_json));
    }

    private JSONObject m_json;
    private LogMessageTranslator m_translator;
}
