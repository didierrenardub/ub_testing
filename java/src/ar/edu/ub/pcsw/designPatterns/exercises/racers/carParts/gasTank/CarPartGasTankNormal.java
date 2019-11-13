package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.gasTank;

import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.CarPartBase;

public class CarPartGasTankNormal extends CarPartBase implements CarPartGasTank
{
    public CarPartGasTankNormal(int antiquity, float quality)
    {
        super(antiquity, quality);
    }

    @Override
    public float capacity()
    {
        return 40;
    }

    @Override
    public String name()
    {
        return "Normal gas tank";
    }
}
