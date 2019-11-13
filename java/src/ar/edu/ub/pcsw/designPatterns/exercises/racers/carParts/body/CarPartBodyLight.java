package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.body;

import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.CarPartBase;

public class CarPartBodyLight extends CarPartBase implements CarPartBody
{
    public CarPartBodyLight(int antiquity, float quality)
    {
        super(antiquity, quality);
    }

    @Override
    public float weight()
    {
        return 40;
    }

    @Override
    public String name()
    {
        return "Light body";
    }
}
