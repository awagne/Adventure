package src;

public class Player {
    private int level = 1;
    private int nextLevel = 25;
    private int max_health = 100;
    private int health = 100;
    private int attack = 1;
    private String weapon = "none";
    private int armour = 0;

    public Player(){

    }

    public int getLevel(){
        return level;
    }

    public int getExp(){
        return nextLevel;
    }

    public int getHealth(){
        return health;
    }

    public int getAttack(){
        return attack;
    }

    public int getArmour(){
        return armour;
    }

    public void LevelUp(){
        max_health += 50;
        health = max_health;
        attack += 2;
        level ++;
        nextLevel = level * 25;
    }
}
