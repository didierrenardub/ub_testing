package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.body;

public class CarPartBodyHeavy extends CarPartBodyBase
{
    public CarPartBodyHeavy(int antiquity, float quality)
    {
        super(antiquity, quality);
    }

    @Override
    public float weight()
    {
        return 100;
    }

    @Override
    public String name()
    {
        return "Heavy body";
    }
}
