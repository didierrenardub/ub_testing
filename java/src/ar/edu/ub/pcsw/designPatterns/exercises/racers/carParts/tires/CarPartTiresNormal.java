package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.tires;

import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.CarPartBase;

public class CarPartTiresNormal extends CarPartBase implements CarPartTires
{
    public CarPartTiresNormal(int antiquity, float quality)
    {
        super(antiquity, quality);
    }

    @Override
    public TireType type()
    {
        return TireType.Normal;
    }

    @Override
    public String name()
    {
        return "Normal tires";
    }
}
