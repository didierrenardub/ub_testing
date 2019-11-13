package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.direction;

import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.CarPartBase;

public class CarPartDirectionFair extends CarPartBase implements CarPartDirection {
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
