package ar.edu.ub.testing.Students;

import ar.edu.ub.testing.Students.base.IExercise;
import ar.edu.ub.testing.Students.base.IStudent;

import java.util.ArrayList;

/**
 * This class is used mainly by the professor to gather statistics from its
 * students, as well as test their exercises.
 */
public class CStudentStatistics
{
    /**
     * Default constructor. Nothing fancy here, just initialization of some stuff.
     */
    public CStudentStatistics()
    {
        m_students = new ArrayList<IStudent>();
    }

    /**
     * Adds a student to student's list.
     *
     * @param student The student to be added.
     */
    public IStudent addStudent(IStudent student) {
        m_students.add(student);
        return student;
    }

    /**
     * Searches for the student with the given name.
     *
     * @param withName The name of the student to be returned.
     * @return The instance of the IStudent object that name belongs to, or null if not found.
     */
    public IStudent student(String withName)
    {
        for(IStudent s : students())
        {
            if(s.name().equalsIgnoreCase(withName))
            {
                return s;
            }
        }

        return null;
    }

    /**
     * Same as above, but search using the student's registration number.
     *
     * @param withRegistrationNumber The registration number to be found.
     * @return The instance of IStudent object that registration number belongs to, or null if not found.
     */
    public IStudent student(int withRegistrationNumber)
    {
        for(IStudent s : students())
        {
            if(s.registrationNumber() == withRegistrationNumber)
            {
                return s;
            }
        }

        return null;
    }

    /**
     * Getter for students array.
     *
     * @return The full array of students.
     */
    public ArrayList<IStudent> students() {
        return m_students;
    }

    /**
     * Computes the percentage of completion of all exercises among all students.
     *
     * @return The percentage of completion of all exercises among all students.
     */
    public float exercisesCompletion()
    {
        int totalExercises = students().size();
        float totalCompletion = totalExercises * 100.0f;
        float completion = 0.0f;
        return completion / totalCompletion * 100.0f;
    }
    
    public void runExercises()
    {
        for(IStudent s : students())
        {
            System.out.println("Running exercises from " + s.name());
            for(IExercise e : s.exercises())
            {
                System.out.println("---------------------------------------------------");
                System.out.println("Exercise " + e.name() + " running:");
                e.run();
            }
            System.out.println("===================================================");
        }
    }
    
    private ArrayList<IStudent> m_students;
}
