package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.engine;

public class CarPartEngineFiat600 extends CarPartEngineBase
{
    public CarPartEngineFiat600(int antiquity, float quality)
    {
        super(antiquity, quality);
    }

    @Override
    public float acceleration()
    {
        return 10;
    }

    @Override
    public float topSpeed()
    {
        return 65;
    }

    @Override
    public String name()
    {
        return "Fiat 600 engine";
    }
}
