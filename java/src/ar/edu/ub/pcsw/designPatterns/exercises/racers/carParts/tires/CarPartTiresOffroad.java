package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.tires;

import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.CarPartBase;

public class CarPartTiresOffroad extends CarPartBase implements CarPartTires
{
    public CarPartTiresOffroad(int antiquity, float quality)
    {
        super(antiquity, quality);
    }

    @Override
    public TireType type()
    {
        return TireType.Offroad;
    }

    @Override
    public String name()
    {
        return "Offroad tires";
    }
}
