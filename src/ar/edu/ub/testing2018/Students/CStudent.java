package ar.edu.ub.testing2018.Students;

import java.util.*;

/**
 Created by Didier on 19/8/2016.
 */
public abstract class CStudent implements IStudent
{
    public void addExercise(IExercise exercise)
    {
        m_exercises.add(exercise);
    }
    
    public IExercise exercise(IExercise.ID withId)
    {
        for(IExercise e : m_exercises)
        {
            if(e.id() == withId)
            {
                return e;
            }
        }
        
        return null;
    }
    
    public float gradesAverage()
    {
        float average = 0.0f;
        
        for(IExercise e : m_exercises)
        {
            average += e.grade();
        }
    
        int gradables = 0;
        for(Map.Entry<Integer, ArrayList<Integer> > grades : m_grades.entrySet())
        {
            for(int i = 0; i < grades.getValue().size(); i++)
            {
                int grade = grades.getValue().get(i);
                if(grade != 0)
                {
                    gradables++;
                    if(grade > 10)
                    {
                        grade /= 10;
                    }
                    average += grade;
                }
            }
        }
        
        average = average / (m_exercises.size() + gradables);
        
        return average;
    }
    
    public int points()
    {
        return m_points;
    }
    
    public int earnedPoints()
    {
        return m_points + m_spent;
    }
    
    public int pointsForClass(int classNumber)
    {
        if(m_grades.containsKey(classNumber))
        {
            int points = 0;
            
            for(Integer g : m_grades.get(classNumber))
            {
                points += g;
            }
            
            return points;
        }
        
        return 0;
    }
    
    public IStudent gradeClass(final int classNumber, final int attendance, final int permanence, final int mandatoryTaskPresentation,
                               final int mandatoryTaskGrade, final int optionalTaskPresentation, final int optionalTaskGrade, final int question)
    {
        if(m_grades.containsKey(classNumber))
        {
            m_points -= pointsForClass(classNumber);
            
            ArrayList<Integer> a = m_grades.get(classNumber);
            a.set(0, attendance);
            a.set(1, permanence);
            a.set(2, mandatoryTaskPresentation);
            a.set(3, mandatoryTaskGrade);
            a.set(4, optionalTaskPresentation);
            a.set(5, optionalTaskGrade);
            a.set(6, question);
        }
        else
        {
            m_grades.put(classNumber, new ArrayList<Integer>()
                {{
                    add(attendance);
                    add(permanence);
                    add(mandatoryTaskPresentation);
                    add(mandatoryTaskGrade);
                    add(optionalTaskPresentation);
                    add(optionalTaskGrade);
                    add(question);
                }});
        }
    
        m_points += pointsForClass(classNumber);
        
        return this;
    }
    
    public IStudent buy(int howMuch)
    {
        m_spent += howMuch;
        return this;
    }
    
    int m_points;
    int m_spent;
    List<IExercise> m_exercises = new LinkedList<IExercise>();
    HashMap<Integer, ArrayList<Integer>> m_grades = new HashMap<Integer, ArrayList<Integer>>();
}
