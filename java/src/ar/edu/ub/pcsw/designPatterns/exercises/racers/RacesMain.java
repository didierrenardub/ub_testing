package ar.edu.ub.pcsw.designPatterns.exercises.racers;

import ar.edu.ub.IMain;

public class RacesMain extends IMain
{
    @Override
    public void run(String[] args)
    {
        CarFactory cf = new CarFactoryRandom();
        TrackFactory tf = new TrackFactoryRandom();
        System.out.println(cf.create());
        System.out.println(tf.create(30));

        //TODO: driver implementations
        //TODO: race business logic
    }
}
