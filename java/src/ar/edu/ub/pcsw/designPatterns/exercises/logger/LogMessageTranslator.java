package ar.edu.ub.pcsw.designPatterns.exercises.logger;

import org.json.JSONArray;
import org.json.JSONObject;

public class LogMessageTranslator
{
    public final static String KEY_MESSAGE_TEXT = "text";
    public final static String KEY_MESSAGE_INFO = "info";
    public final static String KEY_INFO_KEY = "key";
    public final static String KEY_INFO_DATA = "data";

    public JSONObject translateInfo(LogInfo info)
    {
        JSONObject ji = new JSONObject();
        ji.put(KEY_INFO_KEY, info.key());
        ji.put(KEY_INFO_DATA, info.data());
        return ji;
    }

    public LogInfo translateInfo(JSONObject jinfo)
    {
        return new LogInfoPlain(jinfo.getString(KEY_INFO_KEY), jinfo.getString(KEY_INFO_DATA));
    }

    public JSONObject translate(LogMessage message)
    {
        JSONObject j = new JSONObject();
        j.put(KEY_MESSAGE_TEXT, message.text());

        JSONArray jinfo = new JSONArray();
        for(LogInfo info : message.info())
        {
            jinfo.put(this.translateInfo(info));
        }
        j.put(KEY_MESSAGE_INFO, jinfo);

        return j;
    }

    public LogMessage translate(JSONObject message)
    {
        LogMessage lm = new LogMessage();
        lm.setText(message.getString(KEY_MESSAGE_TEXT));
        JSONArray jinfo = message.getJSONArray(KEY_MESSAGE_INFO);
        for(int i = 0; i < jinfo.length(); i++)
        {
            lm.addInfo(this.translateInfo(jinfo.getJSONObject(i)));
        }
        return lm;
    }
}
