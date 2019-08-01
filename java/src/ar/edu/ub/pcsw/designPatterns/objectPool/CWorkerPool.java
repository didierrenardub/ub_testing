package ar.edu.ub.pcsw.designPatterns.objectPool;

import java.util.ArrayList;
import java.util.Random;

public class CWorkerPool
{
    public CWorkerPool(int size)
    {
        this.m_size = size;
        this.m_available = new ArrayList<>();
        this.m_unavailable = new ArrayList<>();

        for(int i = 0; i < this.m_size; i++)
        {
            this.m_available.add(new CWorker(
                    new String[]{"Pedro", "Pablo", "Juan", "Walter", "Oscar"} [(new Random()).nextInt(5)]
                    + " " + new String[]{"Pérez", "Gómez", "Fernández", "Páez", "Schweinsteiger"}[(new Random()).nextInt(5)]
            ));
        }
    }

    public CWorker get()
    {
        if(this.m_available.size() > 0)
        {
            CWorker w = this.m_available.get(0);
            this.m_unavailable.add(this.m_available.remove(0));
            return w;
        }

        return null;
    }

    public void free(CWorker worker)
    {
        if(this.m_unavailable.contains(worker))
        {
            this.m_available.add(this.m_unavailable.remove(0));
        }
    }

    private int m_size;
    private ArrayList<CWorker> m_available;
    private ArrayList<CWorker> m_unavailable;
}
