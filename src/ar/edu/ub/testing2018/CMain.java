package ar.edu.ub.testing2018;

import ar.edu.ub.testing2018.ConsoleWarriors.CPlayer;
import ar.edu.ub.testing2018.ConsoleWarriors.CTournament;
import ar.edu.ub.testing2018.ConsoleWarriors.CWarriorBot;
import ar.edu.ub.testing2018.Flipboard.CFlipBot;
import ar.edu.ub.testing2018.Students.CStudentStatistics;
import ar.edu.ub.testing2018.Students.IStudent;

import java.util.Scanner;

public class CMain
{
    private CMain()
    {
        this.m_stats = null;
    }
    
    private CStudentStatistics stats()
    {
        return m_stats;
    }
    
    private void studentsGrading()
    {
        if(stats() != null)
        {
            System.out.println("Average grades and points:");
            for(IStudent s : stats().students())
            {
                System.out.println("\t" + s.name() + " (" + s.points() + "/" + s.earnedPoints() + "): " + s.gradesAverage());
            }
        }
    }
    
    private int userInput(int min, int max)
    {
        Scanner s = new Scanner(System.in);
        
        int input = min - 1;
        
        while(input < min || input > max)
        {
            try
            {
                input = s.nextInt();
            }
            catch(Exception e)
            {
                s.nextLine();
            }
            finally
            {
                
                if(input < min || input > max)
                {
                    System.out.println("Invalid input, try again:");
                }
            }
        }
        
        return input;
    }

    private void consoleWarriorsTournament()
    {
        CTournament t = new CTournament(100);
        t.addPlayer(new CPlayer("Greiner", new CWarriorBot(t.maxAbility())));
        t.addPlayer(new CPlayer("Aguilera", new CWarriorBot("Optimus", t.maxAbility())));
        t.addPlayer(new CPlayer("Wittbecker", new CWarriorBot("Vader", t.maxAbility())));
        t.addPlayer(new CPlayer("Aldegani", new CWarriorBot("Luke", t.maxAbility())));
        t.play();
    }
    
    private void flipboardTournament()
    {
        ar.edu.ub.testing2018.Flipboard.CTournament t = new ar.edu.ub.testing2018.Flipboard.CTournament();
        t.addPlayer(new CFlipBot("Aguilera"));
        t.addPlayer(new CFlipBot("Greiner"));
        t.addPlayer(new CFlipBot("Wittbecker"));
        t.addPlayer(new CFlipBot("Aldegani"));
        t.play();
    }

    public static void main(String[] args)
    {
        CMain app = new CMain();
    
        System.out.println("Choose an action:\n1 - Run exercises\n2 - Students grading\n3 - Console Warriors tournament\n4 - Flipboard tournament");
    
        switch(app.userInput(1, 4))
        {
            case 1:
                if(app.stats() != null)
                {
                    app.stats().runExercises();
                }
            break;
            
            case 2:
                app.studentsGrading();
            break;
        
            case 3:
                app.consoleWarriorsTournament();
            break;
            
            case 4:
                app.flipboardTournament();
            break;
        }
    }
    
    private CStudentStatistics m_stats;
}
