package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.direction;

public class CarPartDirectionHard extends CarPartDirectionBase
{
    public CarPartDirectionHard(int antiquity, float quality)
    {
        super(antiquity, quality);
    }

    @Override
    public DirectionType type()
    {
        return DirectionType.Mechanic;
    }

    @Override
    public String name()
    {
        return "Mechanic direction";
    }
}
