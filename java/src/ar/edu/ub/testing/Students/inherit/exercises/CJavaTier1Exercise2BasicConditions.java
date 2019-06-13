package ar.edu.ub.testing.Students.inherit.exercises;

import ar.edu.ub.testing.Students.base.CExercise;
import ar.edu.ub.testing.Students.base.CTestOutput;
import ar.edu.ub.testing.Students.inherit.exercises.testers.CJavaTier1Exercise2BasicConditionsTester;

import java.util.List;

public abstract class CJavaTier1Exercise2BasicConditions extends CExercise
{
    public String name()
    {
        return "Java: Basic Conditions";
    }

    /**
     * Given a number, it'll return the same number if it is even,
     * or the number multiplied by 2 if it's odd.
     * @param number The given number to be checked.
     * @return The number multiplied by 2 if odd, or the same number if even.
     */
    public abstract int makeEven(int number);

    public final List<CTestOutput> run()
    {
        return new CJavaTier1Exercise2BasicConditionsTester().run(this);
    }
}
