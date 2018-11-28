package ar.edu.ub.testing2018.Flipboard;

import java.util.List;

/**
 Created by Didier on 9/6/2017.
 */
public abstract class CPlayer
{
    public CPlayer(String name)
    {
        this.m_name = name;
    }
    
    public final String name()
    {
        return this.m_name;
    }
    
    public final int totalFlips()
    {
        return this.m_totalFlips;
    }
    
    public final int currentFlips()
    {
        return this.m_currentFlips;
    }
    
    public final void reset()
    {
        this.m_currentFlips = 0;
    }
    
    public final void addFlips(int amount)
    {
        this.m_currentFlips += amount;
        this.m_totalFlips += amount;
    }
    
    abstract public void play(CBoard b, List<CCard> deck);
    
    private String m_name;
    private int m_totalFlips;
    private int m_currentFlips;
}
