package ar.edu.ub.testing2018.ConsoleWarriors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CTournament
{
    public CTournament(int abilityPoints)
    {
        m_players = new ArrayList<CPlayer>();
        m_matches = new ArrayList<CMatch>();
        m_abilityPoints = abilityPoints;
    }

    public int maxAbility()
    {
        return m_abilityPoints;
    }
    
    public void addPlayer(CPlayer player)
    {
        if(player == null)
        {
            System.out.println("Player cannot be null");
            return;
        }
        else if(player.warrior() == null)
        {
            System.out.println("Player " + player.playerName() + " cannot participate as he has no warrior");
            return;
        }
        else if(!player.warrior().valid())
        {
            System.out.println("Player " + player.playerName() + " cannot participate as his warrior is invalid");
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
                m_matches.add(new CMatch(m_players.get(i), m_players.get(j), m_abilityPoints));
            }
        }
        
        Collections.shuffle(m_matches, new Random(System.nanoTime()));
        
        for(CMatch m : m_matches)
        {
            m.play();
        }
        
        for(CPlayer p : m_players)
        {
            System.out.println(p.playerName() + ": " + p.points() + " points");
        }
    }
    
    private ArrayList<CPlayer> m_players;
    private ArrayList<CMatch> m_matches;
    private int m_abilityPoints;
}
