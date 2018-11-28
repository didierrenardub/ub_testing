package ar.edu.ub.testing2018.Students;

import java.util.ArrayList;

public class CGrader
{
    public static CGrader instance()
    {
        return new CGrader();
    }

    public CGrader()
    {
        m_grades = new ArrayList<>();
    }

    public CGrader addGrade(float grade)
    {
        m_grades.add(grade);

        return this;
    }

    public CGrader completion(float grade)
    {
        return addGrade(grade);
    }

    public CGrader prolixity(float grade)
    {
        return addGrade(grade);
    }

    public CGrader reliability(float grade)
    {
        return addGrade(grade);
    }

    public CGrader design(float grade)
    {
        return addGrade(grade);
    }

    public float finalGrade()
    {
        Float total = 0.0f;
        for(Float g : m_grades)
        {
            total += g;
        }

        return total / m_grades.size();
    }

    ArrayList<Float> m_grades;
}
