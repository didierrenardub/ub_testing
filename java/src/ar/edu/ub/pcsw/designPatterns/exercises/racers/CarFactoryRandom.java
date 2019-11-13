package ar.edu.ub.pcsw.designPatterns.exercises.racers;

import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.CarPart;
import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.body.CarPartBody;
import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.body.CarPartBodyHeavy;
import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.body.CarPartBodyLight;
import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.body.CarPartBodyNormal;
import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.brakes.CarPartBrakes;
import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.brakes.CarPartBrakesHard;
import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.brakes.CarPartBrakesNormal;
import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.brakes.CarPartBrakesSoft;
import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.direction.CarPartDirection;
import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.direction.CarPartDirectionFair;
import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.direction.CarPartDirectionHard;
import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.direction.CarPartDirectionSoft;
import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.engine.*;
import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.gasTank.CarPartGasTank;
import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.gasTank.CarPartGasTankBig;
import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.gasTank.CarPartGasTankNormal;
import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.gasTank.CarPartGasTankSmall;
import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.tires.CarPartTires;
import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.tires.CarPartTiresNormal;
import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.tires.CarPartTiresOffroad;
import ar.edu.ub.pcsw.designPatterns.exercises.racers.carParts.tires.CarPartTiresSmooth;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CarFactoryRandom implements CarFactory
{
    public CarFactoryRandom()
    {
        this.m_bodies = Arrays.asList(new CarPartBodyLight(0, 0), new CarPartBodyNormal(0, 0), new CarPartBodyHeavy(0, 0));
        this.m_brakes = Arrays.asList(new CarPartBrakesSoft(0, 0), new CarPartBrakesNormal(0, 0), new CarPartBrakesHard(0, 0));
        this.m_directions = Arrays.asList(new CarPartDirectionSoft(0, 0), new CarPartDirectionFair(0, 0), new CarPartDirectionHard(0, 0));
        this.m_engines = Arrays.asList(new CarPartEngineFiat600(0, 0), new CarPartEngineKwid(0, 0), new CarPartEngineWeird(0, 0), new CarPartEngineFerrari(0, 0));
        this.m_gasTanks = Arrays.asList(new CarPartGasTankSmall(0, 0), new CarPartGasTankNormal(0, 0), new CarPartGasTankBig(0,0));
        this.m_tires = Arrays.asList(new CarPartTiresSmooth(0, 0), new CarPartTiresNormal(0, 0), new CarPartTiresOffroad(0, 0));
    }

    @Override
    public Car create()
    {
        Car c = new Car();
        c.setBody((CarPartBody)this.random(this.m_bodies));
        c.setBrakes((CarPartBrakes)this.random(this.m_brakes));
        c.setDirection((CarPartDirection)this.random(this.m_directions));
        c.setEngine((CarPartEngine)this.random(this.m_engines));
        c.setGasTank((CarPartGasTank)this.random(this.m_gasTanks));
        c.setTires((CarPartTires)this.random(this.m_tires));
        return c;
    }

    private CarPart random(List<CarPart> fromList)
    {
        Random r = new Random();
        return fromList.get(r.nextInt(fromList.size()));
    }

    private List<CarPart> m_bodies;
    private List<CarPart> m_brakes;
    private List<CarPart> m_directions;
    private List<CarPart> m_engines;
    private List<CarPart> m_gasTanks;
    private List<CarPart> m_tires;
}
