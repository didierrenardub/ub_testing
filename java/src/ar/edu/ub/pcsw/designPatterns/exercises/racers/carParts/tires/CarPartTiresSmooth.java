package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.tires;

import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.CarPartBase;

public class CarPartTiresSmooth extends CarPartBase implements CarPartTires
{
    public CarPartTiresSmooth(int antiquity, float quality)
    {
        super(antiquity, quality);
    }

    @Override
    public TireType type()
    {
        return TireType.Smooth;
    }

    @Override
    public String name()
    {
        return "Smooth tires";
    }
}
