package ar.edu.ub.testing.Students.base;

import java.util.List;

public abstract class CExercise implements IExercise
{
    public final float grade()
    {
        float grade = 0.0f;
        int count = 0;

        List<CTestOutput> o = this.run();
        for(CTestOutput t : o)
        {
            if(t.grade() >= -1)
            {
                grade += t.grade();
                count++;
            }
        }

        return grade / count;
    }
}
