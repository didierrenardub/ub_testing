package ar.edu.ub.testing.Students.base;

import java.util.List;

/**
 * Base class for students. Each student should inherit from it and
 * implement the required methods.
 */
public interface IStudent
{
    /**
     * Getter for the student's name.
     *
     * @return Expected to return the student's full name.
     */
    String name();

    /**
     * Getter for the student's registration number. That is, the one
     * given by the university as enrollment.
     *
     * @return Expected to return the student's registration number.
     */
    int registrationNumber();

    /**
     * Adds an exercise to this student's exercise list.
     *
     * @param exercise
     */
    void addExercise(IExercise exercise);

    /**
     * Returns a list of exercises presumably developed by the student.
     *
     * @return A list of exercises.
     */
    List<IExercise> exercises();

    /**
     * It computes the average grading for the current student, taken from the exercises
     * registered for the current student.
     *
     * @return The average grading for the current student.
     */
    float gradesAverage();
}
