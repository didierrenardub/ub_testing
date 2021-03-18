package ar.edu.ub.pcsw.designPatterns.observer;

import java.util.ArrayList;

public class CNotifier
{
    public CNotifier(String name)
    {
        this.m_name = name;
        this.m_observers = new ArrayList<>();
    }

    public String name()
    {
        return this.m_name;
    }

    public void addObserver(INotificationObserver observer)
    {
        this.m_observers.add(observer);
    }

    public void notify(String message)
    {
        CNotification notification = new CNotification(this, message);
        for(INotificationObserver observer : this.m_observers)
        {
            observer.onNotification(notification);
        }
    }

    private String m_name;
    private ArrayList<INotificationObserver> m_observers;
}
