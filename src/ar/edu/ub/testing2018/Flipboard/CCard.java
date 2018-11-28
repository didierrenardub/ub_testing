package ar.edu.ub.testing2018.Flipboard;

import java.util.Random;

/**
 Created by Didier on 9/6/2017.
 */
public class CCard
{
    public CCard(String owner, int up, int down, int left, int right)
    {
        this.m_owner = owner;
        this.m_up = up;
        this.m_down = down;
        this.m_left = left;
        this.m_right = right;
    }
    
    public CCard(String owner, int totalPoints)
    {
        this.m_owner = owner;
        
        Random r = new Random(System.nanoTime());
        
        for(int i = 0; i < totalPoints; i++)
        {
            switch(r.nextInt(4))
            {
                case 0:
                    if(this.m_up < 9)
                    {
                        this.m_up++;
                    }
                    else
                    {
                        totalPoints++;
                    }
                break;
                
                case 1:
                    if(this.m_down < 9)
                    {
                        this.m_down++;
                    }
                    else
                    {
                        totalPoints++;
                    }
                break;
                
                case 2:
                    if(this.m_left < 9)
                    {
                        this.m_left++;
                    }
                    else
                    {
                        totalPoints++;
                    }
                break;
                
                case 3:
                    if(this.m_right < 9)
                    {
                        this.m_right++;
                    }
                    else
                    {
                        totalPoints++;
                    }
                break;
            }
        }
    }

    public boolean equals(CCard other)
    {
        return this.up() == other.up() && this.down() == other.down() && this.left() == other.left() && this.right() == other.right() && this.owner().equalsIgnoreCase(other.owner());
    }
    
    public int up()
    {
        return this.m_up;
    }
    
    public int down()
    {
        return this.m_down;
    }
    
    public int left()
    {
        return this.m_left;
    }
    
    public int right()
    {
        return this.m_right;
    }
    
    public String owner()
    {
        return this.m_owner;
    }
    
    public boolean flip(String by, int byValue, int myValue)
    {
        if(byValue > myValue && !this.owner().equalsIgnoreCase(by))
        {
            this.setOwner(by);
            return true;
        }
        
        return false;
    }
    
    public void setOwner(String owner)
    {
        this.m_owner = owner;
    }
    
    public void printTop()
    {
        System.out.print(" " + this.up() + " ");
    }
    
    public void printMiddle()
    {
        System.out.print("" + this.left() + this.owner().toUpperCase().charAt(0) + this.right());
    }
    
    public void printBottom()
    {
        System.out.print(" " + this.down() + " ");
    }
    
    private String m_owner;
    private int m_up;
    private int m_down;
    private int m_left;
    private int m_right;
}
