package ar.edu.ub.testing.TicTacToe;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CBoard
{
    public CBoard(int w, int h)
    {
        this.setWidth(w);
        this.setHeight(h);

        for(int x = 0; x < w; x++)
        {
            ArrayList<Character> y = new ArrayList<>();
            y.add(null);
            y.add(null);
            y.add(null);
            this.m_board.add(y);
        }
    }

    public CBoard()
    {
        this(3, 3);
    }

    private void setWidth(int w)
    {
        this.m_width = w;
    }

    private void setHeight(int h)
    {
        this.m_height = h;
    }

    public int width()
    {
        return this.m_width;
    }

    public int height()
    {
        return this.m_height;
    }

    public Character tile(int x, int y)
    {
        if(this.valid(x, y))
        {
            return this.m_board.get(x).get(y);
        }
        return null;
    }

    public boolean valid(int x, int y)
    {
        return this.m_board.size() > 0 && x >= 0 && y >= 0 && x < this.m_board.size() && y < this.m_board.get(0).size();
    }

    public boolean full()
    {
        for(int x = 0; x < this.m_board.size(); x++)
        {
            for(int y = 0; y < this.m_board.size(); y++)
            {
                if(this.m_board.get(x).get(y) == null)
                {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean play(CPlayer who, int x, int y)
    {
        if(who != null && this.valid(x, y) && this.tile(x, y) == null && who.symbol() != null)
        {
            this.m_board.get(x).set(y, who.symbol());
            return true;
        }

        return false;
    }

    public Character checkWin()
    {
        for(int x = 0; x < this.m_board.size(); x++)
        {
            for(int y = 0; y < this.m_board.get(x).size(); y++)
            {
                Character s = this.tile(x, y);
                if(s != null)
                {
                    boolean h_win = this.tile(x - 1, y) == s && this.tile(x + 1, y) == s;
                    boolean v_win = this.tile(x, y - 1) == s && this.tile(x, y + 1) == s;
                    boolean d_win = this.tile(x - 1, y - 1) == s && this.tile(x + 1, y + 1) == s;
                    boolean d2_win = this.tile(x - 1, y + 1) == s && this.tile(x + 1, y - 1) == s;
                    if(h_win || v_win || d_win || d2_win)
                    {
                        return s;
                    }
                }
            }
        }

        return null;
    }

    public CBoard readOnly()
    {
        CBoard b = new CBoard(this.width(), this.height());
        for(int x = 0; x < this.m_board.size(); x++)
        {
            for(int y = 0; y < this.m_board.get(x).size(); y++)
            {
                b.m_board.get(x).set(y, this.m_board.get(x).get(y));
            }
        }
        return b;
    }

    public void draw()
    {
        ArrayList<String> render = new ArrayList<>();
        String hLine = "+";
        for(int x = 0; x < this.m_board.size(); x++)
        {
            hLine += "-";
        }
        hLine += "+";
        render.add(hLine);

        for(int y = 0; y < this.m_board.get(0).size(); y++)
        {
            render.add("|");
            int idx = render.size() - 1;
            for(int x = 0; x < this.m_board.size(); x++)
            {
                Character c = this.tile(x, y);
                if(c == null)
                {
                    render.set(idx, render.get(idx) + " ");
                }
                else
                {
                    render.set(idx, render.get(idx) + c);
                }
            }
            render.set(idx, render.get(idx) + "|");
        }

        render.add(hLine);

        for(int i = 0; i < render.size(); i++)
        {
            System.out.println(render.get(i));
        }
    }

    private int m_width = 0;
    private int m_height = 0;
    private ArrayList<ArrayList<Character> > m_board = new ArrayList<>();
}
