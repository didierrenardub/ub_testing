package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.brakes;

import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.CarPartBase;

public class CarPartBrakesSoft extends CarPartBase implements CarPartBrakes
{
    public CarPartBrakesSoft(int antiquity, float quality)
    {
        super(antiquity, quality);
    }

    @Override
    public float brakesForce()
    {
        return 25;
    }

    @Override
    public float handBrakesForce()
    {
        return 25;
    }

    @Override
    public String name()
    {
        return "Soft brakes";
    }
}
