package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.body;

import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.CarPartBase;

public class CarPartBodyNormal extends CarPartBase implements CarPartBody
{
    public CarPartBodyNormal(int antiquity, float quality)
    {
        super(antiquity, quality);
    }

    @Override
    public float weight()
    {
        return 60;
    }

    @Override
    public String name()
    {
        return "Normal body";
    }
}
