package ar.edu.ub.pcsw.designPatterns.demos;

import ar.edu.ub.pcsw.designPatterns.adapter.CBicycle;
import ar.edu.ub.pcsw.designPatterns.adapter.CBicycleAdapter;
import ar.edu.ub.pcsw.designPatterns.adapter.CCar;
import ar.edu.ub.pcsw.designPatterns.adapter.CVehicleDriver;

public class CAdapterDemo implements IDemo
{
    @Override
    public String name()
    {
        return "Adapter demo";
    }

    @Override
    public void run()
    {
        CVehicleDriver vd = new CVehicleDriver("Pablito", new CCar());
        System.out.println(vd.name() + " will drive home in his car:");
        vd.driveHome();
        System.out.println();
        vd = new CVehicleDriver("Carlitos", new CBicycleAdapter(new CBicycle()));
        System.out.println(vd.name() + " will drive home in his bicycle");
        vd.driveHome();
    }
}
