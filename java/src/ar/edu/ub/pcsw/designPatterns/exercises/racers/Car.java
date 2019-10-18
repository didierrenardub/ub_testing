package ar.edu.ub.pcsw.designPatterns.exercises.racers;

import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.body.CarPartBody;
import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.brakes.CarPartBrakes;
import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.direction.CarPartDirection;
import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.engine.CarPartEngine;
import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.gasTank.CarPartGasTank;
import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.tires.CarPartTires;

public class Car
{
    public Car()
    {

    }

    public boolean start()
    {
        return this.engine() != null && this.direction() != null && this.gasTank() != null && this.tires() != null
                && this.brakes() != null && this.body() != null;
    }

    public CarPartEngine engine()
    {
        return this.m_engine;
    }

    public CarPartDirection direction()
    {
        return this.m_direction;
    }

    public CarPartGasTank gasTank()
    {
        return this.m_gasTank;
    }

    public CarPartTires tires()
    {
        return this.m_tires;
    }

    public CarPartBrakes brakes()
    {
        return this.m_brakes;
    }

    public CarPartBody body()
    {
        return this.m_body;
    }

    public Car setEngine(CarPartEngine engine)
    {
        this.m_engine = engine;
        return this;
    }

    public Car setDirection(CarPartDirection direction)
    {
        this.m_direction = direction;
        return this;
    }

    public Car setGasTank(CarPartGasTank gasTank)
    {
        this.m_gasTank = gasTank;
        return this;
    }

    public Car setTires(CarPartTires tires)
    {
        this.m_tires = tires;
        return this;
    }

    public Car setBrakes(CarPartBrakes brakes)
    {
        this.m_brakes = brakes;
        return this;
    }

    public Car setBody(CarPartBody body)
    {
        m_body = body;
        return this;
    }

    private CarPartEngine m_engine;
    private CarPartDirection m_direction;
    private CarPartGasTank m_gasTank;
    private CarPartTires m_tires;
    private CarPartBrakes m_brakes;
    private CarPartBody m_body;
}
