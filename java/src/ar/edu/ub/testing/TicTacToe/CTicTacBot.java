package ar.edu.ub.testing.TicTacToe;

import java.util.Random;

public class CTicTacBot extends CPlayer
{
    public CTicTacBot(String name)
    {
        super(name);
    }

    public CPosition play(CBoard board)
    {
        Random r = new Random();

        int x = r.nextInt(board.width());
        int y = r.nextInt(board.height());

        while(board.tile(x, y) != null)
        {
            x = r.nextInt(board.width());
            y = r.nextInt(board.height());
        }

        return new CPosition(x, y);
    }
}
