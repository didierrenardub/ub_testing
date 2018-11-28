package ar.edu.ub.testing2018.Students;

/**
 * Interface for exercises. Students will have to implement this interface
 * in order to complete their assignments.
 */
public interface IExercise
{
    /**
     * This enumeration holds the ids of the different exercises to be assigned
     * to the students by the professor. When implementing IExercise interface,
     * the corresponding ID should be returned by method id().
     */
    enum ID
	{
        /** GIT_SETUP exercise tasks:
         1) Setup a GitHub account.
         2) Clone the class' repository.
         */
        GIT_SETUP,
        
        /** STUDENT_CREATION exercise tasks:
         1) Create a branch to work on this exercise. Put it a reasonable name (i.e.: student_creation_renard).
         2) Implement, under your own package name (i.e.: ar.edu.ub.pcsw2016.didierrenard), the IStudent interface
            (i.e.: CStudentDidierRenard).
         3) Implement, under your own package name, the IExercise interface for each of the exercises made up to now
            (GIT_SETUP and STUDENT_CREATION; i.e.: CExerciseGitSetup). In the run() method of GIT_SETUP, just print
            your username.
            In the run method of STUDENT_CREATION, just print the information stored in your CStudentXXXXX class.
         */
        STUDENT_CREATION,
    
        /** ENCODING exercise tasks:
         1) Create a branch to work on this exercise. Remember to use a reasonable name for it.
         2) Implement, under your own package name, the IEncoder interface on a class according to
            the encoding type the professor gave to you (i.e.: CEncoderBinary).
         3) Don't forget to create an IExercise for this exercise. In the run method, perform the
            encoding and printing of various strings.
         */
        ENCODING,
    
        /** EXERCISE_COUNT is just a value that tells us the amount of exercises assigned up to now.
         */
        EXERCISE_COUNT
    }

    /**
     * Getter for exercise ID. It will be used to track completion of student's
     * assignments.
     *
     * @return The Id of the implemented exercise.
     */
    ID id();

    /**
     * The logic of the exercise should be implemented in this method.
     */
    void run();

    /**
     * Returns the grading given to the student for this exercise.
     *
     * @return The grade given (and set) by the professor to the student for the current exercise.
     */
    float grade();

    /**
     * Sets the grading set to the student by the professor for the current exercise.
     * IMPORTANT: this method is not to be called by students, but by the professor instead.
     *
     * @param grade The effective grade given to the student.
     */
    void setGrade(float grade);
}
