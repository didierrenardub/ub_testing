package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.brakes;

public class CarPartBrakesNormal extends CarPartBrakesBase
{
    public CarPartBrakesNormal(int antiquity, float quality)
    {
        super(antiquity, quality);
    }

    @Override
    public float brakesForce()
    {
        return 50;
    }

    @Override
    public float handBrakesForce()
    {
        return 50;
    }

    @Override
    public String name()
    {
        return "Normal brakes";
    }
}
