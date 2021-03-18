package ar.edu.ub.pcsw.designPatterns.observer;

public class CNotification
{
    public CNotification(CNotifier sender, String text)
    {
        this.m_sender = sender;
        this.m_text = text;
    }

    public CNotifier sender()
    {
        return this.m_sender;
    }

    public String text()
    {
        return this.m_text;
    }

    private CNotifier m_sender;
    private String m_text;
}
