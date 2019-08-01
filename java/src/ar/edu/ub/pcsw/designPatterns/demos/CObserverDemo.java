package ar.edu.ub.pcsw.designPatterns.demos;

import ar.edu.ub.pcsw.designPatterns.observer.CNotificationPrinter;
import ar.edu.ub.pcsw.designPatterns.observer.CNotifier;
import ar.edu.ub.pcsw.designPatterns.strategy.CPrintStrategyCommon;
import ar.edu.ub.pcsw.designPatterns.strategy.CPrintStrategyKanji;

public class CObserverDemo implements IDemo
{
    @Override
    public String name()
    {
        return "Observer demo";
    }

    @Override
    public void run()
    {
        CNotifier a = new CNotifier("Weather");
        CNotifier b = new CNotifier("Sports");

        CNotificationPrinter np = new CNotificationPrinter(new CPrintStrategyCommon());
        a.addObserver(np);
        b.addObserver(np);
        np = new CNotificationPrinter(new CPrintStrategyKanji());
        a.addObserver(np);
        b.addObserver(np);

        a.notify("Weather is 57°C in CABA, Argentina");
        System.out.println("***************************************");
        b.notify("River won 7-1 against Boca");
        System.out.println("***************************************");
        a.notify("It'll rain tomorrow in Burzaco");
        System.out.println("***************************************");
        b.notify("Villa Dalmine scored against Villa San Carlos for a 3-1 win");
    }
}
