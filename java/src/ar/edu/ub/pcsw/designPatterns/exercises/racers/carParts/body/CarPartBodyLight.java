package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.body;

public class CarPartBodyLight extends CarPartBodyBase
{
    public CarPartBodyLight(int antiquity, float quality)
    {
        super(antiquity, quality);
    }

    @Override
    public float weight()
    {
        return 40;
    }

    @Override
    public String name()
    {
        return "Light body";
    }
}
