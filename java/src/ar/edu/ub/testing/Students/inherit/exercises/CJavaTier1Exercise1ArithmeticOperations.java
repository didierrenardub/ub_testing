package ar.edu.ub.testing.Students.inherit.exercises;

import ar.edu.ub.testing.Students.base.CExercise;
import ar.edu.ub.testing.Students.base.CTestOutput;
import ar.edu.ub.testing.Students.inherit.exercises.testers.CJavaTier1Exercise1ArithmeticOperationsTester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class CJavaTier1Exercise1ArithmeticOperations extends CExercise
{
    public String name()
    {
        return "Java: Arithmetical operations";
    }

    public abstract int add(int a, int b);
    public abstract int subtract(int a, int b);
    public abstract int multiply(int a, int b);
    public abstract int divide(int a, int b);
    public abstract int squarePower(int a);

    public final List<CTestOutput> run()
    {
        return new CJavaTier1Exercise1ArithmeticOperationsTester().run(this);
    }
}
