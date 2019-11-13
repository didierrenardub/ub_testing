package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.brakes;

import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.CarPartBase;

public class CarPartBrakesHard extends CarPartBase implements CarPartBrakes
{
    public CarPartBrakesHard(int antiquity, float quality)
    {
        super(antiquity, quality);
    }

    @Override
    public float brakesForce()
    {
        return 75;
    }

    @Override
    public float handBrakesForce()
    {
        return 75;
    }

    @Override
    public String name()
    {
        return "Hard brakes";
    }
}
