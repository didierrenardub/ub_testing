package ar.edu.ub.testing.Students.inherit.exercises.testers;

import ar.edu.ub.testing.Students.base.CTestOutput;
import ar.edu.ub.testing.Students.inherit.exercises.CJavaTier1Exercise2BasicConditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CJavaTier1Exercise2BasicConditionsTester
{
    public final List<CTestOutput> run(CJavaTier1Exercise2BasicConditions ex)
    {
        List<CTestOutput> o = new ArrayList<>();

        this.testAdd(o, ex);

        return o;
    }

    private void testAdd(List<CTestOutput> o, CJavaTier1Exercise2BasicConditions ex)
    {
        List<List<Integer>> addTests = Arrays.asList(
                Arrays.asList(1, 10, -1,  -5, 33), // a parameter
                Arrays.asList(2, 10, -2, -10, 66) // expected result
        );

        float score = 0;
        for(int i = 0; i < addTests.get(0).size(); i++)
        {
            int result = -66;

            try
            {
                result = ex.makeEven(addTests.get(0).get(i));
            }
            catch(Exception e)
            {
                o.add(new CTestOutput("CJT1E2::makeEven WARNING Exception thrown: " + e.getMessage()));
            }

            if(result != addTests.get(1).get(i))
            {
                o.add(new CTestOutput("CJT1E2::makeEven FAILED at making " + addTests.get(0).get(i) + " even; expected " + addTests.get(1).get(i) + ", got " + result));
            }
            else
            {
                score += 10;
            }
        }
        o.add(new CTestOutput("Score for CJT1E2::makeEven tests: " + score / addTests.get(0).size()));
    }
}
