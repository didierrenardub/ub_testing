package ar.edu.ub.pcsw.designPatterns.adapter;

public class CCar implements IVehicle
{
    public CCar()
    {

    }

    @Override
    public void throttle()
    {
        System.out.println("Hitting the gas pedal");
    }

    @Override
    public void brake()
    {
        System.out.println("Hitting the brakes");
    }

    @Override
    public void steerLeft()
    {
        System.out.println("Turning the steering wheel to the left");
    }

    @Override
    public void steerRight()
    {
        System.out.println("Turning the steering wheel to the right");
    }

    @Override
    public void horn()
    {
        System.out.println("BEEEEP");
    }
}
