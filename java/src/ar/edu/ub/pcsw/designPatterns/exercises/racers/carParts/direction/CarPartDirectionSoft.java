package ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.direction;

import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.CarPartBase;

public class CarPartDirectionSoft extends CarPartBase implements CarPartDirection {
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
