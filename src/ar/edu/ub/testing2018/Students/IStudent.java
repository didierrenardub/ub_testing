package ar.edu.ub.testing2018.Students;

import java.util.ArrayList;

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
     * @return Expected to return the student's registration number;
     */
    int registrationNumber();

    /**
     * Adds an exercise to this student's exercise list.
     *
     * @param exercise
     */
    void addExercise(IExercise exercise);

    /**
     * Returns the instance of exercise that matches the given ID, or null if it doesn't exist.
     *
     * @param withId The ID of the requested exercise.
     * @return The exercise itself, or null if not found.
     */
    IExercise exercise(IExercise.ID withId);

    /**
     * It computes the average grading for the current student, taken from the exercises
     * registered for the current student.
     *
     * @return The average grading for the current student.
     */
    float gradesAverage();
    
    /**
     * Getter for the current amount of points owned by the current student
     * based on its performance.
     *
     * @return The amount of points owned by the current student
     */
    int points();
    
    /**
     * Getter for the total amount of points earned by the current student
     * in the whole class.
     *
     * @return The total amount of points earned by the current student.
     */
    int earnedPoints();
    
    /**
     * Getter for the amount of points earned by the current student in the
     * selected class.
     *
     * @param classNumber The class number to get the points from.
     * @return The amount of points earned by the current student in the given class.
     */
    int pointsForClass(int classNumber);
    
    /**
     * Grants points to the current student for the different things being
     * evaluated.
     *
     * @return Pointer to the current student, for ease of usage.
     */
    IStudent gradeClass(int classNumber, int attendance, int permanence, int mandatoryTaskPresentation,
                        int mandatoryTaskGrade, int optionalTaskPresentation, int optionalTaskGrade, int question);
    
    /**
     * Used to remove points from the student after he buys something.
     *
     * @param howMuch The amount of points spent by the current student.
     * @return Pointer to the current student, for ease of usage.
     */
    IStudent buy(int howMuch);
}
