package ar.edu.ub.testing2018.ConsoleWarriors;

public class CPlayer
{
    public CPlayer(String playerName, CWarrior warrior)
    {
        this.m_playerName = playerName;
        this.m_warrior = warrior;
    }
    
    public CWarrior warrior()
    {
        return this.m_warrior;
    }
    
    public String playerName()
    {
        return this.m_playerName;
    }
    
    public int points()
    {
        return this.m_points;
    }
    
    public void win(int points)
    {
        this.m_points += points;
    }
    
    public void draw()
    {
        this.m_points += 1;
    }
    
    private String m_playerName;
    private CWarrior m_warrior;
    private int m_points;
}
