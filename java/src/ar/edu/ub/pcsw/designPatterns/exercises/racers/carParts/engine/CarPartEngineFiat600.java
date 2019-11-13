package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.engine;

import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.CarPartBase;

public class CarPartEngineFiat600 extends CarPartBase implements CarPartEngine
{
    public CarPartEngineFiat600(int antiquity, float quality)
    {
        super(antiquity, quality);
    }

    @Override
    public float acceleration()
    {
        return 10;
    }

    @Override
    public float topSpeed()
    {
        return 65;
    }

    @Override
    public String name()
    {
        return "Fiat 600 engine";
    }
}
