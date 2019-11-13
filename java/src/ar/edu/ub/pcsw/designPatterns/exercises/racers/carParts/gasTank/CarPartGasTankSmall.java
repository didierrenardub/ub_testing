package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.gasTank;

import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.CarPartBase;

public class CarPartGasTankSmall extends CarPartBase implements CarPartGasTank
{
    public CarPartGasTankSmall(int antiquity, float quality)
    {
        super(antiquity, quality);
    }

    @Override
    public float capacity()
    {
        return 30;
    }

    @Override
    public String name()
    {
        return "Small gas tank";
    }
}
