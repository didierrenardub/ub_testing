package ar.edu.ub.testing2018.ConsoleWarriors;

import java.util.ArrayList;
import java.util.Random;

public class CMatch
{
    public CMatch(CPlayer p1, CPlayer p2, int abilityLimit)
    {
        this.m_home = p1;
        this.m_away = p2;
    }
    
    public CPlayer home()
    {
        return this.m_home;
    }
    
    public CPlayer away()
    {
        return this.m_away;
    }
    
    public void play()
    {
        print("***********************\n", 0);
        print("Next match:\n"
                + home().playerName() + " with \"" + home().warrior().name() + "\"\n" + "vs.\n"
                + away().playerName() + " with \"" + away().warrior().name() + "\"\n", 0);
        print("***********************\n", 0);
        print(home().warrior().name() + ": H" + home().warrior().health() + " / P" + home().warrior().power() + " / D" + home().warrior().defense() + " / A" + home().warrior().accuracy() + " / " + home().warrior().ability().id().toString() + "\n", 0);
        print(away().warrior().name() + ": H" + away().warrior().health() + " / P" + away().warrior().power() + " / D" + away().warrior().defense() + " / A" + away().warrior().accuracy() + " / " + away().warrior().ability().id().toString() + "\n", 0);
        print("***********************\n", WAIT_TIME * 3);

        ArrayList<WARRIOR_ACTION> hAct = new ArrayList<>();
        ArrayList<WARRIOR_ACTION> aAct = new ArrayList<>();

        home().warrior().reset();
        away().warrior().reset();

        while(home().warrior().alive() && away().warrior().alive())
        {
            WARRIOR_STATUS hStatus = home().warrior().status();
            WARRIOR_STATUS aStatus = away().warrior().status();

            hAct.add(validate(home().warrior(), home().warrior().action(away().warrior(), aAct)));
            aAct.add(validate(away().warrior(), away().warrior().action(home().warrior(), hAct)));

            if(lastAction(hAct) == WARRIOR_ACTION.ATTACK && lastAction(aAct) != WARRIOR_ACTION.ATTACK)
            {
                processAttack(home().warrior(), away().warrior(), lastAction(aAct));
            }
            else if(lastAction(aAct) == WARRIOR_ACTION.ATTACK && lastAction(hAct) != WARRIOR_ACTION.ATTACK)
            {
                processAttack(away().warrior(), home().warrior(), lastAction(hAct));
            }
            else if(lastAction(aAct) == lastAction(hAct) && lastAction(hAct) == WARRIOR_ACTION.BLOCK)
            {
                print("Both warriors tried to defend themselves.\n");
            }
            else if(lastAction(aAct) == lastAction(hAct) && lastAction(hAct) == WARRIOR_ACTION.NONE)
            {
                print("Both warriors were idle; nothing happened.\n");
            }
            else if(lastAction(aAct) == lastAction(hAct) && lastAction(hAct) == WARRIOR_ACTION.ATTACK)
            {
                if(m_random.nextBoolean())
                {
                    processAttack(home().warrior(), away().warrior(), lastAction(aAct));
                    processAttack(away().warrior(), home().warrior(), lastAction(hAct));
                }
                else
                {
                    processAttack(away().warrior(), home().warrior(), lastAction(hAct));
                    processAttack(home().warrior(), away().warrior(), lastAction(aAct));
                }
            }

            print(home().warrior().name() + " has " + home().warrior().currentHealth() + "/" + home().warrior().health() + "; " + away().warrior().name() + " has " + away().warrior().currentHealth() + "/" + away().warrior().health() + "\n");

            if(hStatus == home().warrior().status() && hStatus != WARRIOR_STATUS.NORMAL)
            {
                home().warrior().normalize();
                print(home().warrior().name() + " came back to normal\n");
            }

            if(aStatus == away().warrior().status() && aStatus != WARRIOR_STATUS.NORMAL)
            {
                away().warrior().normalize();
                print(away().warrior().name() + " came back to normal\n");
            }

            print("\n", 0);
        }

        if(home().warrior().alive())
        {
            print(home().playerName() + ", with " + home().warrior().name() + ", won the match!\n", WAIT_TIME * 2);
            home().win(home().warrior().currentHealth());
        }
        else
        {
            print(away().playerName() + ", with " + away().warrior().name() + ", won the match!\n", WAIT_TIME * 2);
            away().win(away().warrior().currentHealth());
        }
    }

    public WARRIOR_ACTION validate(CWarrior warrior, WARRIOR_ACTION action)
    {
        if(warrior.status() == WARRIOR_STATUS.STUNNED || (warrior.status() == WARRIOR_STATUS.DIZZY && !m_random.nextBoolean()))
        {
            return WARRIOR_ACTION.NONE;
        }

        return action;
    }

    public void processAttack(CWarrior attacker, CWarrior defender, WARRIOR_ACTION defenderAction)
    {
        if(defenderAction == WARRIOR_ACTION.NONE)
        {
            print(defender.name() + " shows no resistance!\n", WAIT_TIME);
            attack(attacker, defender);
        }
        else
        {
            boolean blocked = m_random.nextInt(greatestAbility(defender)) < defender.defense();
            boolean broke = attacker.ability().id() == WARRIOR_ABILITY.LOW_KICK && m_random.nextInt(100) < 15;

            if(blocked && !broke)
            {
                print(defender.name() + " blocked the attack.\n", WAIT_TIME);
            }
            else
            {
                if(broke)
                {
                    print("Attacker broke the defense with a LOW KICK! ", 0);
                }

                attack(attacker, defender);
            }
        }
    }

    public int greatestAbility(CWarrior w)
    {
        int p = w.power();
        int h = w.health();
        int a = w.accuracy();
        int d = w.defense();

        return Math.max(p, Math.max(h, Math.max(a, d)));
    }

    public void attack(CWarrior attacker, CWarrior defender)
    {
        boolean hit = m_random.nextInt(greatestAbility(attacker)) < attacker.accuracy();
        boolean avoid = defender.ability().id() == WARRIOR_ABILITY.AGILITY && m_random.nextInt(100) < 20;

        if(!hit && attacker.ability().id() == WARRIOR_ABILITY.FOCUS && m_random.nextInt(100) < 30)
        {
            hit = true;
            print("Attacker was focused; ", 0);
        }

        if(hit && !avoid)
        {
            int amount = Math.max(1, (int)(attacker.power() / 2 * (1.0f - defender.defense() / 100.0f)));
            boolean rage = attacker.ability().id() == WARRIOR_ABILITY.RAGE && m_random.nextInt(100) < 25;
            boolean suckerPunch = attacker.ability().id() == WARRIOR_ABILITY.SUCKER_PUNCH && m_random.nextInt(100) < 20;
            boolean headAttack = attacker.ability().id() == WARRIOR_ABILITY.HEADBUTT && m_random.nextInt(100) < 15;

            if(rage)
            {
                amount *= 2;
            }

            if(defender.ability().id() == WARRIOR_ABILITY.MIRROR && m_random.nextInt(100) < 15)
            {
                print(defender.name() + " mirrored " + attacker.name() + "'s attack back to himself!!!\n", WAIT_TIME);
                defender = attacker;
            }

            if(rage)
            {
                print(attacker.name() + " hit " + defender.name() + " with RAGE", 0);
            }
            else
            {
                print(attacker.name() + " hit " + defender.name(), 0);
            }

            if(suckerPunch)
            {
                defender.makeDizzy();
                print(" and made him dizzy", 0);
            }
            else if(headAttack)
            {
                defender.stun();
                print(" and stunned him", 0);
            }

            defender.hit(amount);
            print("\n");
        }
        else if(!hit)
        {
            print(attacker.name() + " missed!!!", 0);

            if(defender.ability().id() == WARRIOR_ABILITY.CONFUSE && m_random.nextInt(100) < 30)
            {
                print(" and " + defender.name() + " confused him!", 0);
                attacker.makeDizzy();
            }

            print("\n", WAIT_TIME);

        }
        else if(avoid)
        {
            print(defender.name() + " avoided the attack thanks to his AGILITY\n");
        }
    }

    public void print(String str)
    {
        print(str, WAIT_TIME);
    }
    
    public void print(String str, long time) // wait long time? boring
    {
        System.out.print(str);
        try
        {
            Thread.sleep(time);
        }
        catch(InterruptedException e)
        {
            
        }
    }

    private WARRIOR_ACTION lastAction(ArrayList<WARRIOR_ACTION> from)
    {
        return from.get(from.size() - 1);
    }
    
    private CPlayer m_home;
    private CPlayer m_away;
    private Random m_random = new Random();

    private final long WAIT_TIME = 500;
}
