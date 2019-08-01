package ar.edu.ub.pcsw.designPatterns.demos;

import ar.edu.ub.pcsw.designPatterns.objectPool.CWorker;
import ar.edu.ub.pcsw.designPatterns.objectPool.CWorkerPool;

import java.util.ArrayList;
import java.util.Random;

public class CObjectPoolDemo implements IDemo
{
    @Override
    public String name()
    {
        return "Object Pool demo";
    }

    @Override
    public void run()
    {
        ArrayList<CWorker> onSite = new ArrayList<>();
        CWorkerPool wp = new CWorkerPool(7);
        for(int i = 0; i < 20; i++)
        {
            System.out.println("Need a worker, will get one from the pool:");
            CWorker w = wp.get();
            if(w != null)
            {
                onSite.add(w);
                System.out.println(w.name() + " joined the site");
            }
            else
            {
                System.out.println("*** No more workers in the pool!");
            }

            if(new Random().nextBoolean())
            {
                System.out.println("Sending " + onSite.get(0).name() + " home");
                wp.free(onSite.remove(0));
            }
        }
    }
}
