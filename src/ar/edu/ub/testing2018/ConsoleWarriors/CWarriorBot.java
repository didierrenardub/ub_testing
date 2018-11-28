package ar.edu.ub.testing2018.ConsoleWarriors;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Didier on 21/10/2016.
 */
public class CWarriorBot extends CWarrior
{
    public CWarriorBot(int abilityPoints)
    {
        this("Megatron", abilityPoints);
    }

    public CWarriorBot(String warriorName, int abilityPoints)
    {
        super(abilityPoints);

        Random r = new Random();
        m_warriorName = warriorName;
        m_health = 1;
        m_defense = 1;
        m_power = 1;
        m_accuracy = 1;
        while(!valid())
        {
            switch(r.nextInt() % 4)
            {
                case 0:
                    m_health++;
                    break;

                case 1:
                    m_defense++;
                    break;

                case 2:
                    m_power++;
                    break;

                case 3:
                    m_accuracy++;
                    break;
            }
        }
    }

    public String name()
    {
        return m_warriorName;
    }

    public int health()
    {
        return m_health;
    }

    public int defense()
    {
        return m_defense;
    }

    public int power()
    {
        return m_power;
    }

    public int accuracy()
    {
        return m_accuracy;
    }

    public CWarriorAbility ability()
    {
        return m_ability;
    }

    public WARRIOR_ACTION action(CWarrior opponent, ArrayList<WARRIOR_ACTION> opponentMoves)
    {
        if(new Random().nextBoolean())
        {
            return WARRIOR_ACTION.ATTACK;
        }

        return WARRIOR_ACTION.BLOCK;
    }

    private String m_warriorName;
    private int m_health;
    private int m_defense;
    private int m_power;
    private int m_accuracy;
    private CWarriorAbility m_ability = CWarriorAbility.random();
}
