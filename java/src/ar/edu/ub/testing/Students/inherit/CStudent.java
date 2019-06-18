package ar.edu.ub.testing.Students.inherit;

import ar.edu.ub.testing.Students.base.IExercise;
import ar.edu.ub.testing.Students.base.IStudent;

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

    public List<IExercise> exercises()
    {
        return m_exercises;
    }
    
    public float gradesAverage()
    {
        float average = 0.0f;
        
        for(IExercise e : m_exercises)
        {
            average += e.grade();
        }
        
        return average / m_exercises.size();
    }
    
    int m_points;
    int m_spent;
    List<IExercise> m_exercises = new LinkedList<IExercise>();
    HashMap<Integer, ArrayList<Integer>> m_grades = new HashMap<Integer, ArrayList<Integer>>();
}
