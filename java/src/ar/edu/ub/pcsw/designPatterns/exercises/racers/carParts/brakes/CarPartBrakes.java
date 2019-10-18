package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.brakes;

import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.CarPart;

public interface CarPartBrakes extends CarPart
{
    float brakesForce();
    float handBrakesForce();
}
