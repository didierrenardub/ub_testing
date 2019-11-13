package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.engine;

import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.CarPartBase;

public class CarPartEngineWeird extends CarPartBase implements CarPartEngine
{
    public CarPartEngineWeird(int antiquity, float quality)
    {
        super(antiquity, quality);
    }

    @Override
    public float acceleration()
    {
        return 4;
    }

    @Override
    public float topSpeed()
    {
        return 500;
    }

    @Override
    public String name()
    {
        return "Weird engine";
    }
}
