package ar.edu.ub.testing2018.Flipboard;

import java.util.List;
import java.util.Random;

/**
 Created by Didier on 9/6/2017.
 */
public class CFlipBot extends CPlayer
{
    public CFlipBot(String name)
    {
        super(name);
    }
    
    public void play(CBoard b, List<CCard> deck)
    {
        Random r = new Random();
        int x = 0;
        int y = 0;
        
        do
        {
            x = r.nextInt(b.width());
            y = r.nextInt(b.height());
            
        } while(b.cardAt(x, y) != null);
        
        b.addCard(deck.get(r.nextInt(deck.size())), x, y);
    }
}
