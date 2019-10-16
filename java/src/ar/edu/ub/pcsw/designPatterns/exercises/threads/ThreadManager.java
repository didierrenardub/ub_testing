package ar.edu.ub.pcsw.designPatterns.exercises.threads;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class ThreadManager implements JobMonitor
{
    public ThreadManager(int threadCount)
    {
        this.m_threadCount = threadCount;
        this.m_threads = new ArrayList<>();
        this.m_jobs = new ArrayList<>();
    }

    public void start()
    {
        for(int i = 0; i < this.m_threadCount; i++)
        {
            this.m_threads.add(new WorkerThread(this));
        }
    }

    public void stop(boolean completeJobs)
    {
        while(completeJobs)
        {
            try
            {
                completeJobs = !this.m_jobs.isEmpty();
                Thread.sleep(1);
            }
            catch(InterruptedException ie)
            {
                System.out.println(ie.getMessage());
                ie.printStackTrace();
            }
        }

        for(WorkerThread wt : this.m_threads)
        {
            wt.stop();
        }
        this.m_threads.clear();
    }

    public void stop()
    {
        this.stop(true);
    }

    public synchronized void work(Job onJob)
    {
        this.m_jobs.add(onJob);
    }

    public synchronized Job job()
    {
        if(this.m_jobs.size() > 0)
        {
            return this.m_jobs.remove(0);
        }

        return null;
    }

    @Override
    public void jobFinished(Job sender)
    {
        System.out.println(sender.name() + " complete");
    }

    private int m_threadCount;
    private ArrayList<WorkerThread> m_threads;
    private ArrayList<Job> m_jobs;
}
