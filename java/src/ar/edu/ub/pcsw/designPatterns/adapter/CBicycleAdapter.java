package ar.edu.ub.pcsw.designPatterns.adapter;

public class CBicycleAdapter implements IVehicle
{
    public CBicycleAdapter(CBicycle bicycle)
    {
        this.m_bicycle = bicycle;
    }

    @Override
    public void throttle()
    {
        this.m_bicycle.pedal();
    }

    @Override
    public void brake()
    {
        this.m_bicycle.backBrake();
        this.m_bicycle.frontBrake();
    }

    @Override
    public void steerLeft()
    {
        this.m_bicycle.turn("left");
    }

    @Override
    public void steerRight()
    {
        this.m_bicycle.turn("right");
    }

    @Override
    public void horn()
    {
        this.m_bicycle.ring();
    }

    private CBicycle m_bicycle;
}
