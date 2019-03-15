package ar.edu.ub.testing.TicTacToe;

public abstract class CPlayer
{
    public CPlayer(String name)
    {
        this.setName(name);
    }

    private void setName(String name)
    {
        this.m_name = name;
    }

    public final void setSymbol(Character symbol)
    {
        this.m_symbol = symbol;
    }

    public final String name()
    {
        return this.m_name;
    }

    public final Character symbol()
    {
        return this.m_symbol;
    }

    public final void win()
    {
        this.m_won++;
    }

    public final void draw()
    {
        this.m_drawn++;
    }

    public final void lose()
    {
        this.m_lost++;
    }

    public final int won()
    {
        return this.m_won;
    }

    public final int drawn()
    {
        return this.m_drawn;
    }

    public final int lost()
    {
        return this.m_lost;
    }

    public final int points()
    {
        return this.won() * 3 + this.drawn();
    }

    public abstract CPosition play(CBoard where);

    private String m_name = "";
    private Character m_symbol = 'x';
    private int m_won = 0;
    private int m_drawn = 0;
    private int m_lost = 0;
}
