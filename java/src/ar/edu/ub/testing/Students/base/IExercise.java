package ar.edu.ub.testing.Students.base;

import java.util.List;

/**
 * Interface for exercises. Students will have to implement this interface
 * in order to complete their assignments.
 */
public interface IExercise
{
    /**
     * Getter for exercise name.
     *
     * @return The name of the implemented exercise.
     */
    String name();

    /**
     * The logic of the exercise should be implemented in this method.
     *
     * @return An array of Strings with the output of the tests.
     */
    List<CTestOutput> run();

    /**
     * Returns the grading given to the student for this exercise.
     *
     * @return The grade given (and set) by the professor to the student for the current exercise.
     */
    float grade();
}
