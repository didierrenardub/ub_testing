package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.body;

import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.body.CarPartBodyBase;

public class CarPartBodyNormal extends CarPartBodyBase
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
