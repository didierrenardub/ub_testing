package ar.edu.ub.pcsw.designPatterns.command;

import java.util.ArrayList;

public interface ICalculatorCommand
{
    String name();
    int run(ArrayList<Integer> args);
}
