package ar.edu.ub.pcsw.designPatterns.exercises.threads;

public interface Job
{
    String name();
    void run(ThreadManager owner);
}
