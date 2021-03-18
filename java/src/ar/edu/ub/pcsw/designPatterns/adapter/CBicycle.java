package ar.edu.ub.pcsw.designPatterns.adapter;

public class CBicycle
{
    public CBicycle()
    {
    }

    public void pedal()
    {
        System.out.println("Pedaling");
    }

    public void backBrake()
    {
        System.out.println("Pulling the back brakes");
    }

    public void frontBrake()
    {
        System.out.println("Pulling the front brakes");
    }

    public void turn(String side)
    {
        System.out.println("Turning handlebar to the " + side);
    }

    public void ring()
    {
        System.out.println("Ring ring");
    }
}
