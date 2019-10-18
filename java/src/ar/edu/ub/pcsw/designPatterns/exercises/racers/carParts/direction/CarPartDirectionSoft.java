package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.direction;

public class CarPartDirectionSoft extends CarPartDirectionBase
{
    public CarPartDirectionSoft(int antiquity, float quality)
    {
        super(antiquity, quality);
    }

    @Override
    public DirectionType type()
    {
        return DirectionType.Hydraulic;
    }

    @Override
    public String name()
    {
        return "Hydraulic direction";
    }
}
