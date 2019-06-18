package ar.edu.ub.testing.Students.inherit.exercises.testers;

import ar.edu.ub.testing.Students.base.CTestOutput;
import ar.edu.ub.testing.Students.inherit.exercises.CJavaTier1Exercise1ArithmeticOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CJavaTier1Exercise1ArithmeticOperationsTester
{
    public final List<CTestOutput> run(CJavaTier1Exercise1ArithmeticOperations ex)
    {
        List<CTestOutput> o = new ArrayList<>();

        this.testAdd(o, ex);
        this.testSubtract(o, ex);
        this.testMultiply(o, ex);
        this.testDivide(o, ex);
        this.testSquarePower(o, ex);

        return o;
    }

    private void testAdd(List<CTestOutput> o, CJavaTier1Exercise1ArithmeticOperations ex)
    {
        List<List<Integer>> addTests = Arrays.asList(
                Arrays.asList(1, 10, -1, -1, 10,  10, -5), // a parameter
                Arrays.asList(1, 89,  1, -1, -1, -11,  6), // b parameter
                Arrays.asList(2, 99,  0, -2,  9,  -1,  1) // expected result
        );

        float score = 0;
        for(int i = 0; i < addTests.get(0).size(); i++)
        {
            int result = -66;

            try
            {
                result = ex.add(addTests.get(0).get(i), addTests.get(1).get(i));
            }
            catch(Exception e)
            {
                o.add(new CTestOutput("CJT1E1::add WARNING Exception thrown: " + e.getMessage()));
            }

            if(result != addTests.get(2).get(i))
            {
                o.add(new CTestOutput("CJT1E1::add FAILED at adding " + addTests.get(1).get(i) + " to " + addTests.get(0).get(i) + "; expected " + addTests.get(2).get(i) + ", got " + result));
            }
            else
            {
                score += 10;
            }
        }
        o.add(new CTestOutput("Score for CJT1E1::add tests: " + score / addTests.get(0).size()));
    }

    private void testSubtract(List<CTestOutput> o, CJavaTier1Exercise1ArithmeticOperations ex)
    {
        List<List<Integer>> subtractTests = Arrays.asList(
                Arrays.asList(1, 89, -1, -1, 10,  10,  -5), // a parameter
                Arrays.asList(1, 10,  1, -1, -1, -11,   6), // b parameter
                Arrays.asList(0, 79, -2,  0, 11,  21, -11) // expected result
        );

        float score = 0;
        for(int i = 0; i < subtractTests.get(0).size(); i++)
        {
            int result = -66;

            try
            {
                result = ex.subtract(subtractTests.get(0).get(i), subtractTests.get(1).get(i));
            }
            catch(Exception e)
            {
                o.add(new CTestOutput("CJT1E1::subtract WARNING Exception thrown: " + e.getMessage()));
            }

            if(result != subtractTests.get(2).get(i))
            {
                o.add(new CTestOutput("CJT1E1::subtract FAILED at subtracting " + subtractTests.get(1).get(i) + " from " + subtractTests.get(0).get(i) + "; expected " + subtractTests.get(2).get(i) + ", got " + result));
            }
            else
            {
                score += 10;
            }
        }
        o.add(new CTestOutput("Score for CJT1E1::subtract tests: " + score / subtractTests.get(0).size()));
    }

    private void testMultiply(List<CTestOutput> o, CJavaTier1Exercise1ArithmeticOperations ex)
    {
        List<List<Integer>> multiplyTests = Arrays.asList(
                Arrays.asList(1,  10, -1, -1,  10,   10,  -5, 100, 0, -5), // a parameter
                Arrays.asList(1,  89,  1, -1,  -1,  -11,   6,   0, 5, -5), // b parameter
                Arrays.asList(1, 890, -1,  1, -10, -110, -30,   0, 0, 25) // expected result
        );

        float score = 0;
        for(int i = 0; i < multiplyTests.get(0).size(); i++)
        {
            int result = -666;

            try
            {
                result = ex.multiply(multiplyTests.get(0).get(i), multiplyTests.get(1).get(i));
            }
            catch(Exception e)
            {
                o.add(new CTestOutput("CJT1E1::multiply WARNING Exception thrown: " + e.getMessage()));
            }

            if(result != multiplyTests.get(2).get(i))
            {
                o.add(new CTestOutput("CJT1E1::multiply FAILED at multiplying " + multiplyTests.get(0).get(i) + " by " + multiplyTests.get(1).get(i) + "; expected " + multiplyTests.get(2).get(i) + ", got " + result));
            }
            else
            {
                score += 10;
            }
        }
        o.add(new CTestOutput("Score for CJT1E1::multiply tests: " + score / multiplyTests.get(0).size()));
    }

    private void testDivide(List<CTestOutput> o, CJavaTier1Exercise1ArithmeticOperations ex)
    {
        List<List<Integer>> divideTests = Arrays.asList(
                Arrays.asList(1,  10, -1, -1,  10,   89,  -6,  100, 0, -5), // a parameter
                Arrays.asList(1,  89,  1, -1,  -1,   10,   5,    0, 5, -5), // b parameter
                Arrays.asList(1,   0, -1,  1, -10,    8,  -1, -666, 0,  1) // expected result
        );

        float score = 0;
        for(int i = 0; i < divideTests.get(0).size(); i++)
        {
            int result = -666;

            try
            {
                result = ex.divide(divideTests.get(0).get(i), divideTests.get(1).get(i));
            }
            catch(ArithmeticException e)
            {
                // Expected
            }
            catch(Exception e)
            {
                o.add(new CTestOutput("CJT1E1::divide WARNING Exception thrown: " + e.getMessage()));
            }

            if(result != divideTests.get(2).get(i))
            {
                o.add(new CTestOutput("CJT1E1::divide FAILED at dividing " + divideTests.get(0).get(i) + " by " + divideTests.get(1).get(i) + "; expected " + divideTests.get(2).get(i) + ", got " + result));
            }
            else
            {
                score += 10;
            }
        }
        o.add(new CTestOutput("Score for CJT1E1::divide tests: " + score / divideTests.get(0).size()));
    }

    private void testSquarePower(List<CTestOutput> o, CJavaTier1Exercise1ArithmeticOperations ex)
    {
        List<List<Integer>> squarePowerTests = Arrays.asList(
                Arrays.asList(1,  10, -1, -5, 0), // a parameter
                Arrays.asList(1, 100,  1, 25, 0) // expected result
        );

        float score = 0;
        for(int i = 0; i < squarePowerTests.get(0).size(); i++)
        {
            int result = -666;

            try
            {
                result = ex.squarePower(squarePowerTests.get(0).get(i));
            }
            catch(Exception e)
            {
                o.add(new CTestOutput("CJT1E1::squarePower WARNING Exception thrown: " + e.getMessage()));
            }

            if(result != squarePowerTests.get(2).get(i))
            {
                o.add(new CTestOutput("CJT1E1::squarePower FAILED at powering " + squarePowerTests.get(0).get(i) + " by 2; expected " + squarePowerTests.get(1).get(i) + ", got " + result));
            }
            else
            {
                score += 10;
            }
        }
        o.add(new CTestOutput("Score for CJT1E1::squarePower tests: " + score / squarePowerTests.get(0).size()));
    }
}
