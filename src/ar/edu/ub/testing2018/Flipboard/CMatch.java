package ar.edu.ub.testing2018.Flipboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 Created by Didier on 9/6/2017.
 */
public class CMatch
{
    public CMatch(CPlayer home, CPlayer away)
    {
        this.m_home = home;
        this.m_away = away;
        this.m_turn = this.m_home;
        this.m_board = new CBoard();
        
        this.m_homeDeck = new ArrayList<>();
        this.m_awayDeck = new ArrayList<>();
        
        this.m_homeDeck.add(new CCard(this.m_home.name(), 30));
        this.m_awayDeck.add(new CCard(this.m_away.name(), 30));
        
        for(int i = 0; i < 2; i++)
        {
            this.addUniqueCard(this.m_homeDeck, this.m_home.name(), 27);
            this.addUniqueCard(this.m_awayDeck, this.m_away.name(), 27);
        }
    
        for(int i = 0; i < 4; i++)
        {
            this.addUniqueCard(this.m_homeDeck, this.m_home.name(), 24);
            this.addUniqueCard(this.m_awayDeck, this.m_away.name(), 24);
        }
    
        for(int i = 0; i < 4; i++)
        {
            this.addUniqueCard(this.m_homeDeck, this.m_home.name(), 21);
            this.addUniqueCard(this.m_awayDeck, this.m_away.name(), 21);
        }
    
        for(int i = 0; i < 5; i++)
        {
            this.addUniqueCard(this.m_homeDeck, this.m_home.name(), 16);
            this.addUniqueCard(this.m_awayDeck, this.m_away.name(), 16);
        }
    
        Collections.shuffle(m_homeDeck, new Random(System.nanoTime()));
        Collections.shuffle(m_awayDeck, new Random(System.nanoTime()));
    }

    public void addUniqueCard(ArrayList<CCard> toList, String owner, int points)
    {
        CCard toAdd = new CCard(owner, points);
        while(!this.addUnique(toList, toAdd))
        {
            toAdd = new CCard(owner, points);
        }
    }

    public boolean addUnique(ArrayList<CCard> toList, CCard card)
    {
        for(CCard c : toList)
        {
            if(c.equals(card))
            {
                return false;
            }
        }

        toList.add(card);
        return true;
    }
    
    public void play()
    {
        print("========================================\n", 0);
        while(!this.m_board.full() && m_homeDeck.size() > 0 && m_awayDeck.size() > 0)
        {
            this.m_board.print();
            print("");
            print("\nIt's " + this.m_turn.name() + "'s turn: ");
            
            List<CCard> l = this.m_homeDeck;
            
            if(this.m_turn == this.m_away)
            {
                l = this.m_awayDeck;
            }
            
            this.m_turn.play(this.m_board, l.subList(0, Math.min(4, l.size() - 1)));
            
            if(this.m_board.lastMoveFlips() > 0)
            {
                print(this.m_turn.name() + " flipped " + this.m_board.lastMoveFlips() + " cards!\n");
            }
            else
            {
                print(this.m_turn.name() + " did not flip any card.\n");
            }
            
            this.m_turn.addFlips(this.m_board.lastMoveFlips());
            
            if(this.m_board.lastPlayed() != null)
            {
                l.remove(this.m_board.lastPlayed());
            }
            
            if(this.m_turn == this.m_home)
            {
                this.m_turn = this.m_away;
            }
            else
            {
                this.m_turn = this.m_home;
            }
        }

        this.m_board.print();
        
        CPlayer winner = this.m_away;
        if(this.m_home.currentFlips() > this.m_away.currentFlips())
        {
            winner = this.m_home;
        }
        else if(this.m_home.currentFlips() == this.m_away.currentFlips())
        {
            winner = null;
        }
        
        if(winner != null)
        {
            print(winner.name() + " have won the match!\n");
        }
        else
        {
            print("It's a tie.\n");
        }
        print("========================================\n", 0);
        
        this.m_home.reset();
        this.m_away.reset();
    }
    
    public void print(String str)
    {
        print(str, WAIT_TIME);
    }
    
    public void print(String str, long time) // wait long time? boring
    {
        System.out.print(str);
        try
        {
            Thread.sleep(time);
        }
        catch(InterruptedException e)
        {
        
        }
    }
    
    private CPlayer m_turn;
    private CBoard m_board;
    
    private CPlayer m_home;
    private CPlayer m_away;
    
    private ArrayList<CCard> m_homeDeck;
    private ArrayList<CCard> m_awayDeck;
    
    private final long WAIT_TIME = 1000;
}
