package ar.edu.ub.pcsw.designPatterns.demos;

import java.util.Scanner;

public abstract class CDemoBase implements IDemo
{
    public CDemoBase()
    {
    }

    public String readString()
    {
        Scanner s = new Scanner(System.in);
        String i = s.nextLine();
        return i;
    }

    public float readFloat()
    {
        Scanner s = new Scanner(System.in);
        float f = s.nextFloat();
        return f;
    }
}
