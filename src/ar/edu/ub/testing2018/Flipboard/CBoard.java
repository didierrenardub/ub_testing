package ar.edu.ub.testing2018.Flipboard;

import java.util.ArrayList;

/**
 Created by Didier on 9/6/2017.
 */
public class CBoard
{
    public CBoard()
    {
        this(3, 4);
    }
    
    public CBoard(int width, int height)
    {
        this.m_board = new ArrayList<>();
        this.m_lastPlayed = null;
        this.m_lastMoveFlips = 0;
        
        for(int x = 0; x < width; x++)
        {
            this.m_board.add(new ArrayList<CCard>());
            for(int y = 0; y < height; y++)
            {
                this.m_board.get(x).add(null);
            }
        }
    }
    
    public int width()
    {
        return this.m_board.size();
    }
    
    public int height()
    {
        return this.m_board.get(0).size();
    }
    
    public CCard cardAt(int x, int y)
    {
        if(valid(x, y))
        {
            return this.m_board.get(x).get(y);
        }
        
        return null;
    }
    
    public CCard lastPlayed()
    {
        CCard ret = this.m_lastPlayed;
        this.m_lastPlayed = null;
        return ret;
    }
    
    public int lastMoveFlips()
    {
        return this.m_lastMoveFlips;
    }
    
    public boolean addCard(CCard card, int x, int y)
    {
        this.m_lastPlayed = card;
        this.m_lastMoveFlips = 0;
        
        if(valid(x, y) && this.cardAt(x, y) == null)
        {
            this.m_board.get(x).set(y, card);
            
            if(x > 0)
            {
                CCard other = this.m_board.get(x - 1).get(y);
                if(other != null && other.flip(card.owner(), card.left(), other.right()))
                {
                    this.m_lastMoveFlips++;
                }
            }
            
            if(x < this.m_board.size() - 1)
            {
                CCard other = this.m_board.get(x + 1).get(y);
                if(other != null && other.flip(card.owner(), card.right(), other.left()))
                {
                    this.m_lastMoveFlips++;
                }
            }
    
            if(y > 0)
            {
                CCard other = this.m_board.get(x).get(y - 1);
                if(other != null && other.flip(card.owner(), card.up(), other.down()))
                {
                    this.m_lastMoveFlips++;
                }
            }
    
            if(y < this.m_board.get(0).size() - 1)
            {
                CCard other = this.m_board.get(x).get(y + 1);
                if(other != null && other.flip(card.owner(), card.down(), other.up()))
                {
                    this.m_lastMoveFlips++;
                }
            }
            
            return true;
        }
        
        return false;
    }
    
    public boolean full()
    {
        for(int x = 0; x < this.m_board.size(); x++)
        {
            for(int y = 0; y < this.m_board.get(x).size(); y++)
            {
                if(this.m_board.get(x).get(y) == null)
                {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public void print()
    {
        System.out.print("+");
        for(int x = 0; x < this.m_board.size() * 3 + 2; x++)
        {
            System.out.print("-");
        }
        System.out.println("+");
        
        for(int y = 0; y < this.m_board.get(0).size(); y++)
        {
            System.out.print("|");
            
            for(int x = 0; x < this.m_board.size(); x++)
            {
                if(this.m_board.get(x).get(y) != null)
                {
                    this.m_board.get(x).get(y).printTop();
                }
                else
                {
                    System.out.print("   ");
                }
                
                if(x != this.m_board.size() - 1)
                {
                    System.out.print(" ");
                }
            }
            
            System.out.println("|");
            System.out.print("|");
    
            for(int x = 0; x < this.m_board.size(); x++)
            {
                if(this.m_board.get(x).get(y) != null)
                {
                    this.m_board.get(x).get(y).printMiddle();
                }
                    else
                {
                    System.out.print("   ");
                }
    
                if(x != this.m_board.size() - 1)
                {
                    System.out.print(" ");
                }
            }
    
            System.out.println("|");
            System.out.print("|");
            
            for(int x = 0; x < this.m_board.size(); x++)
            {
                if(this.m_board.get(x).get(y) != null)
                {
                    this.m_board.get(x).get(y).printBottom();
                }
                else
                {
                    System.out.print("   ");
                }
    
                if(x != this.m_board.size() - 1)
                {
                    System.out.print(" ");
                }
            }
    
            System.out.println("|");
        }
    
        System.out.print("+");
        for(int x = 0; x < this.m_board.size() * 3 + 2; x++)
        {
            System.out.print("-");
        }
        System.out.println("+");
    }
    
    private boolean valid(int x, int y)
    {
        return x >= 0 && x < this.m_board.size() && y >= 0 && y <= this.m_board.get(0).size();
    }
    
    private ArrayList<ArrayList<CCard> > m_board;
    private CCard m_lastPlayed = null;
    private int m_lastMoveFlips;
}
