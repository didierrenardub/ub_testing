package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.direction;

import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.CarPartBase;

public class CarPartDirectionHard extends CarPartBase implements CarPartDirection {
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
