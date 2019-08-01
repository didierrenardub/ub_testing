package ar.edu.ub.pcsw.designPatterns.observer;

import ar.edu.ub.pcsw.designPatterns.strategy.IPrintStrategy;

public class CNotificationPrinter implements INotificationObserver
{
    public CNotificationPrinter(IPrintStrategy printingStrategy)
    {
        this.m_printingStrategy = printingStrategy;
    }

    @Override
    public void onNotification(CNotification message)
    {
        this.m_printingStrategy.run(message.sender().name() + " sent \"" + message.text() + "\"");
    }

    private IPrintStrategy m_printingStrategy;
}
