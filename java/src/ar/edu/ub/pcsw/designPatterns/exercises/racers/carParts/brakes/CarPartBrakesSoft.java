package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.brakes;

public class CarPartBrakesSoft extends CarPartBrakesBase
{
    public CarPartBrakesSoft(int antiquity, float quality)
    {
        super(antiquity, quality);
    }

    @Override
    public float brakesForce()
    {
        return 25;
    }

    @Override
    public float handBrakesForce()
    {
        return 25;
    }

    @Override
    public String name()
    {
        return "Soft brakes";
    }
}
