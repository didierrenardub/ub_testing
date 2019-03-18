package ar.edu.ub.testing.TicTacToe;

public class CPosition
{
    public CPosition(int x, int y)
    {
        this.setX(x);
        this.setY(y);
    }

    public void setX(int x)
    {
        this.m_x = x;
    }

    public void setY(int y)
    {
        this.m_y = y;
    }

    public int x()
    {
        return this.m_x;
    }

    public int y()
    {
        return this.m_y;
    }

    private int m_x = 0;
    private int m_y = 0;
}
