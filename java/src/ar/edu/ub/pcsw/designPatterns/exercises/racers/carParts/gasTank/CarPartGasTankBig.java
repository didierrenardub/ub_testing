package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.gasTank;

import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.CarPartBase;

public class CarPartGasTankBig extends CarPartBase implements CarPartGasTank
{
    public CarPartGasTankBig(int antiquity, float quality)
    {
        super(antiquity, quality);
    }

    @Override
    public float capacity()
    {
        return 60;
    }

    @Override
    public String name()
    {
        return "Big gas tank";
    }
}
