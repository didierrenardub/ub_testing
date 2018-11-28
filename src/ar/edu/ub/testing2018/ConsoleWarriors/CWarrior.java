package ar.edu.ub.testing2018.ConsoleWarriors;

import java.util.ArrayList;

/**
 Created by Didier on 21/10/2016.
 */
public abstract class CWarrior
{
    abstract public String name();
    abstract public int power();
    abstract public int health();
    abstract public int accuracy();
    abstract public int defense();
    abstract public CWarriorAbility ability();
    abstract public WARRIOR_ACTION action(CWarrior opponent, ArrayList<WARRIOR_ACTION> opponentActions);
    
    public CWarrior(int abilityPoints)
    {
        this.m_totalAbilityPoints = abilityPoints;
        this.m_status = WARRIOR_STATUS.NORMAL;
        this.m_currentHealth = 0;
    }
    
    public final boolean valid()
    {
        if(power() < 1 || health() < 1 || accuracy() < 1 || defense() < 1)
        {
            return false;
        }
        
        int value = -1;
        for(int i = 0; i < 10; i++)
        {
            if(value != -1 && value != power())
            {
                return false;
            }
            
            value = power();
        }
        
        CWarriorAbility a = this.ability();
        for(int i = 0; i < 10; i++)
        {
            if(a != this.ability())
            {
                return false;
            }
            
            a = this.ability();
        }
        
        return (power() + health() + accuracy() + defense() + ability().cost()) == m_totalAbilityPoints;
    }

    public final void hit(int by)
    {
        this.m_currentHealth -= by;
    }

    public final int currentHealth()
    {
        return this.m_currentHealth;
    }

    public final boolean alive()
    {
        return this.m_currentHealth > 0;
    }

    public final void reset()
    {
        this.m_currentHealth = health();
        this.m_status = WARRIOR_STATUS.NORMAL;
    }
    
    public final WARRIOR_STATUS status()
    {
        return m_status;
    }
    
    public final void stun()
    {
        m_status = WARRIOR_STATUS.STUNNED;
    }
    
    public final void makeDizzy()
    {
        m_status = WARRIOR_STATUS.DIZZY;
    }
    
    public final void normalize()
    {
        m_status = WARRIOR_STATUS.NORMAL;
    }
    
    private int m_totalAbilityPoints;
    private WARRIOR_STATUS m_status;
    private int m_currentHealth;
}
