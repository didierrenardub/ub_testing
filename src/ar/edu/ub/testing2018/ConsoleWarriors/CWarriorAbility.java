package ar.edu.ub.testing2018.ConsoleWarriors;

import java.util.Random;

public class CWarriorAbility
{
    public static CWarriorAbility rage()
    {
        return new CWarriorAbility(WARRIOR_ABILITY.RAGE, 5);
    }

    public static CWarriorAbility agility()
    {
        return new CWarriorAbility(WARRIOR_ABILITY.AGILITY, 4);
    }

    public static CWarriorAbility suckerPunch()
    {
        return new CWarriorAbility(WARRIOR_ABILITY.SUCKER_PUNCH, 5);
    }
    
    public static CWarriorAbility headbutt()
    {
        return new CWarriorAbility(WARRIOR_ABILITY.HEADBUTT, 6);
    }

    public static CWarriorAbility focus()
    {
        return new CWarriorAbility(WARRIOR_ABILITY.FOCUS, 3);
    }

    public static CWarriorAbility lowKick()
    {
        return new CWarriorAbility(WARRIOR_ABILITY.LOW_KICK, 5);
    }

    public static CWarriorAbility confuse()
    {
        return new CWarriorAbility(WARRIOR_ABILITY.CONFUSE, 4);
    }

    public static CWarriorAbility mirror()
    {
        return new CWarriorAbility(WARRIOR_ABILITY.MIRROR, 6);
    }

    public static CWarriorAbility none()
    {
        return new CWarriorAbility(WARRIOR_ABILITY.NONE, 0);
    }

    public static CWarriorAbility random()
    {
        switch(WARRIOR_ABILITY.values()[new Random().nextInt(WARRIOR_ABILITY.values().length)])
        {
            case RAGE: return rage();
            case AGILITY: return agility();
            case SUCKER_PUNCH: return suckerPunch();
            case HEADBUTT: return headbutt();
            case FOCUS: return focus();
            case LOW_KICK: return lowKick();
            case CONFUSE: return confuse();
            case MIRROR: return mirror();
            case NONE: return none();
        }

        return none();
    }

    public WARRIOR_ABILITY id()
    {
        return this.m_id;
    }

    public int cost()
    {
        return this.m_cost;
    }

    private CWarriorAbility(WARRIOR_ABILITY id, int cost)
    {
        this.m_id = id;
        this.m_cost = cost;
    }

    private WARRIOR_ABILITY m_id;
    private int m_cost;
}