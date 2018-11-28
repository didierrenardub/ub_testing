package ar.edu.ub.testing2018.Flipboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 Created by Didier on 9/6/2017.
 
 */

public class CTournament
{
    public CTournament()
    {
        m_players = new ArrayList<CPlayer>();
        m_matches = new ArrayList<CMatch>();
    }
    
    public void addPlayer(CPlayer player)
    {
        if(player == null)
        {
            System.out.println("Player cannot be null");
            return;
        }
        else if(player.name() == null || player.name() == "")
        {
            System.out.println("Player has no name");
            return;
        }
        
        m_players.add(player);
    }
    
    public void play()
    {
        for(int i = 0; i < m_players.size(); i++)
        {
            for(int j = i + 1; j < m_players.size(); j++)
            {
                m_matches.add(new CMatch(m_players.get(i), m_players.get(j)));
            }
        }
        
        Collections.shuffle(m_matches, new Random(System.nanoTime()));
        
        for(CMatch m : m_matches)
        {
            m.play();
        }
        
        for(CPlayer p : m_players)
        {
            System.out.println(p.name() + ": " + p.totalFlips() + " points");
        }
    }
    
    private ArrayList<CPlayer> m_players;
    private ArrayList<CMatch> m_matches;
}
