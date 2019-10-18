package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.engine;

public class CarPartEngineKwid extends CarPartEngineBase
{
    public CarPartEngineKwid(int antiquity, float quality)
    {
        super(antiquity, quality);
    }

    @Override
    public float acceleration()
    {
        return 8;
    }

    @Override
    public float topSpeed()
    {
        return 140;
    }

    @Override
    public String name()
    {
        return "Kwid engine";
    }
}