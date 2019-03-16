package ar.edu.ub.testing.TicTacToe;

import java.util.ArrayList;

public class CMatch
{
    public final static int MESSAGE_DELAY = 1000;

    public CMatch(CPlayer home, CPlayer away, int messageDelay)
    {
        this.setHome(home);
        this.setAway(away);
        this.setTurn(this.home());
        this.setMessageDelay(messageDelay);
        this.setBoard(new CBoard());
    }

    public CMatch(CPlayer home, CPlayer away)
    {
        this(home, away, MESSAGE_DELAY);
    }

    private void setHome(CPlayer home)
    {
        this.m_home = home;
        this.m_home.setSymbol('X');
    }

    private void setAway(CPlayer away)
    {
        this.m_away = away;
        this.m_away.setSymbol('O');
    }

    private void setTurn(CPlayer turn)
    {
        this.m_turn = turn;
    }

    public void setMessageDelay(int delay)
    {
        this.m_messageDelay = delay;
    }

    private void setBoard(CBoard b)
    {
        this.m_board = b;
    }

    public CPlayer home()
    {
        return this.m_home;
    }

    public CPlayer away()
    {
        return this.m_away;
    }

    public CPlayer turn()
    {
        return this.m_turn;
    }

    public int messageDelay()
    {
        return this.m_messageDelay;
    }

    public CBoard board()
    {
        return this.m_board;
    }

    public void addMessage(String message)
    {
        this.m_log.add(message);
        this.delay();
    }

    public CPlayer disqualify(String message)
    {
        this.addMessage(message);
        CPlayer winner = this.home();

        if(this.turn() == this.home())
        {
            winner = this.away();
        }
        this.draw();

        return winner;
    }

    private void delay()
    {
        try
        {
            Thread.sleep(this.messageDelay());
        }
        catch(Exception e)
        {
        }
    }

    public CPlayer play()
    {
        while(this.board().checkWin() == null && !this.board().full())
        {
            CPosition p = this.turn().play(this.board().readOnly());

            if(this.board().play(this.turn(), p.x(), p.y()))
            {
                this.addMessage(this.turn().name() + " played " + this.turn().symbol() + " at (" + p.x() + ", " + p.y() + ")");
                this.draw();
            }
            else
            {
                return this.disqualify(this.turn().name() + " made an ilegal move, disqualifying");
            }

            if(this.turn() == this.home())
            {
                this.setTurn(this.away());
            }
            else
            {
                this.setTurn(this.home());
            }
        }

        this.setTurn(null);

        CPlayer winner = null;
        if(this.board().checkWin() == this.home().symbol())
        {
            winner = this.home();
        }
        else if(this.board().checkWin() == this.away().symbol())
        {
            winner = this.away();
        }

        if(winner != null)
        {
            this.addMessage(winner.name() + " has won the match!");
        }
        else
        {
            this.addMessage("It's a tie");
        }
        this.draw();

        return winner;
    }

    private void draw()
    {
        if(this.m_log.size() > 0)
        {
            System.out.println(this.m_log.get(this.m_log.size() - 1));
        }

        if(this.turn() != null)
        {
            this.board().draw();
        }
    }

    private CPlayer m_home = null;
    private CPlayer m_away = null;
    private CPlayer m_turn = null;
    private int m_messageDelay = 0;
    private CBoard m_board = null;
    private ArrayList<String> m_log = new ArrayList<>();
}
