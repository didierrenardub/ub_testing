package ar.edu.ub.pcsw.designPatterns.strategy;

import java.util.ArrayList;

public class CPrintStrategyKanji implements IPrintStrategy
{
    @Override
    public void run(String what)
    {
        int rows = (int)Math.ceil(Math.sqrt(what.length()));
        ArrayList<StringBuilder> lines = new ArrayList<>();
        int columns = (int)Math.ceil(what.length() / (float)rows);
        for(int j = 0; j < columns; j++)
        {
            lines.add(new StringBuilder());
            for(int k = 0; k < rows; k++)
            {
                lines.get(lines.size() - 1).append(' ');
            }
        }

        int x = lines.get(0).length() - 1;
        int y = 0;

        for(int j = 0; j < what.length(); j++)
        {
            lines.get(y).replace(x, x + 1, "" + what.charAt(j));
            y++;
            if(y >= lines.size())
            {
                y = 0;
                x--;
            }
        }

        for(StringBuilder sb : lines)
        {
            System.out.println(sb.toString());
        }
    }
}
