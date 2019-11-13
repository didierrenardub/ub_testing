package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.body;

import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.CarPartBase;

public class CarPartBodyHeavy extends CarPartBase implements CarPartBody
{
    public CarPartBodyHeavy(int antiquity, float quality)
    {
        super(antiquity, quality);
    }

    @Override
    public float weight()
    {
        return 100;
    }

    @Override
    public String name()
    {
        return "Heavy body";
    }
}
