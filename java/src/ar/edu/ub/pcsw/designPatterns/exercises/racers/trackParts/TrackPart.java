package ar.edu.ub.pcsw.designPatterns.exercises.racers.trackParts;

import ar.edu.ub.pcsw.designPatterns.exercises.racers.Car;
import ar.edu.ub.pcsw.designPatterns.exercises.racers.Driver;

public interface TrackPart
{
    boolean onCarPassing(Car car, Driver driver);
}
