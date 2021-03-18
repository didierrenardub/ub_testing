package ar.edu.ub.pcsw.designPatterns.adapter;

public class CVehicleDriver
{
    public CVehicleDriver(String name, IVehicle vehicle)
    {
        this.m_name = name;
        this.m_vehicle = vehicle;
    }

    public String name()
    {
        return this.m_name;
    }

    public IVehicle vehicle()
    {
        return this.m_vehicle;
    }

    public void driveHome()
    {
        this.vehicle().throttle();
        this.vehicle().brake();
        this.vehicle().steerLeft();
        this.vehicle().throttle();
        this.vehicle().horn();
        this.vehicle().throttle();
        this.vehicle().brake();
        this.vehicle().steerRight();
        this.vehicle().throttle();
        this.vehicle().brake();
    }

    private String m_name;
    private IVehicle m_vehicle;
}
