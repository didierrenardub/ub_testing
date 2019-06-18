package ar.edu.ub.testing.TicTacToe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CTournament
{
    public final static int MESSAGE_DELAY = 1000;

    public CTournament(int messageDelay)
    {
        this.m_messageDelay = messageDelay;
    }

    public CTournament()
    {
        this(MESSAGE_DELAY);
    }

    public void addPlayer(CPlayer player)
    {
        if (player != null && player.name() != null && !player.name().equals("") && !this.m_players.contains(player)) {
            this.m_players.add(player);
        }
    }

    public void play()
    {
        for(int i = 0; i < this.m_players.size(); i++)
        {
            for(int j = i + 1; j < this.m_players.size(); j++)
            {
                this.m_matches.add(new CMatch(this.m_players.get(i), this.m_players.get(j), this.m_messageDelay));
                this.m_matches.add(new CMatch(this.m_players.get(j), this.m_players.get(i), this.m_messageDelay));
            }
        }

        Collections.shuffle(this.m_matches);

        for(int m = 0; m < this.m_matches.size(); m++)
        {
            CMatch mm = this.m_matches.get(m);
            CPlayer winner = mm.play();

            if(winner != null)
            {
                winner.win();
                if(winner == mm.home())
                {
                    mm.away().lose();
                }
                else if(winner == mm.away())
                {
                    mm.home().lose();
                }
            }
            else
            {
                mm.home().draw();
                mm.away().draw();
            }
        }

        Collections.sort(this.m_players, new Comparator<CPlayer>()
        {
            public int compare(CPlayer a, CPlayer b)
            {
                return a.points() - b.points();
            }
        });

        for(int i = 0; i < this.m_players.size(); i++)
        {
            CPlayer p = this.m_players.get(i);
            System.out.println(p.name() + ": Points: " + p.points() + " - Won: " + p.won() + " - Drawn: " + p.drawn() + " - Lost: " + p.lost());
        }
    }

    private ArrayList<CPlayer> m_players = new ArrayList<>();
    private ArrayList<CMatch> m_matches = new ArrayList<>();
    private int m_messageDelay = 0;
}
