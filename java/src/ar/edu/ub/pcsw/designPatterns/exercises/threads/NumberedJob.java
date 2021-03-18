package ar.edu.ub.pcsw.designPatterns.exercises.threads;

public class NumberedJob implements Job
{
    public NumberedJob(int jobNumber)
    {
        this.m_jobNumber = jobNumber;
    }

    @Override
    public String name()
    {
        return "job #" + this.m_jobNumber;
    }

    @Override
    public void run(ThreadManager owner)
    {
        System.out.println("Hi, I'm " + this.name());
    }

    private int m_jobNumber;
}
