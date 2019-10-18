package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.engine;

public class CarPartEngineFerrari extends CarPartEngineBase
{
    public CarPartEngineFerrari(int antiquity, float quality)
    {
        super(antiquity, quality);
    }

    @Override
    public float acceleration()
    {
        return 12;
    }

    @Override
    public float topSpeed()
    {
        return 320;
    }

    @Override
    public String name()
    {
        return "Ferrari engine";
    }
}
