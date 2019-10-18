package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.engine;

import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.CarPart;

public interface CarPartEngine extends CarPart
{
    float acceleration();
    float topSpeed();
}
