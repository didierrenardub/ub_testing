package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.brakes;

import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.CarPartBase;

public class CarPartBrakesNormal extends CarPartBase implements CarPartBrakes
{
    public CarPartBrakesNormal(int antiquity, float quality)
    {
        super(antiquity, quality);
    }

    @Override
    public float brakesForce()
    {
        return 50;
    }

    @Override
    public float handBrakesForce()
    {
        return 50;
    }

    @Override
    public String name()
    {
        return "Normal brakes";
    }
}
