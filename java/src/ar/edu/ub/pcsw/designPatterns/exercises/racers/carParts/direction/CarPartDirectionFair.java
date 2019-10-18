package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.direction;

public class CarPartDirectionFair extends CarPartDirectionBase
{
    public CarPartDirectionFair(int antiquity, float quality)
    {
        super(antiquity, quality);
    }

    @Override
    public DirectionType type()
    {
        return DirectionType.Assisted;
    }

    @Override
    public String name()
    {
        return "Assisted direction";
    }
}
