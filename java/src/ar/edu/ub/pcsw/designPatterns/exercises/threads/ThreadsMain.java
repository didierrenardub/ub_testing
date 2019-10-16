package ar.edu.ub.pcsw.designPatterns.exercises.threads;

import ar.edu.ub.IMain;

public class ThreadsMain extends IMain
{
    @Override
    public void run(String[] args)
    {
        ThreadManager tm = new ThreadManager(Runtime.getRuntime().availableProcessors());
        tm.start();
        for(int i = 0; i < 100; i++)
        {
            tm.work(new NumberedJob(i));
        }
        tm.stop();
    }
}
