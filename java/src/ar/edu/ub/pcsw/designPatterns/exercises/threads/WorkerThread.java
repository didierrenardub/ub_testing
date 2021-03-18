package ar.edu.ub.pcsw.designPatterns.exercises.threads;

import java.util.concurrent.atomic.AtomicBoolean;

public class WorkerThread implements Runnable
{
    public WorkerThread(ThreadManager owner)
    {
        this.m_running = new AtomicBoolean(true);
        this.m_owner = owner;
        this.m_thread = new Thread(this);
        this.m_thread.start();
    }

    @Override
    public void run()
    {
        while(this.m_running.get())
        {
            Job j = this.m_owner.job();

            if(j != null)
            {
                j.run(this.m_owner);
                this.m_owner.jobFinished(j);
            }

            try
            {
                Thread.sleep(1);
            }
            catch(InterruptedException ie)
            {
                System.out.println(ie.getMessage());
                ie.printStackTrace();
            }
        }
    }

    public void stop()
    {
        try
        {
            this.m_running.set(false);
            this.m_thread.join();
        }
        catch(InterruptedException ie)
        {
            System.out.println(ie.getMessage());
            ie.printStackTrace();
        }
    }

    private Thread m_thread;
    private ThreadManager m_owner;
    private AtomicBoolean m_running;
}
