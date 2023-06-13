package src;

public class Enemy {

    private boolean burning = false;
    private boolean frozen = false;
    private int health = 100;
    private int attack = 1;
    private String name = "";

    public Enemy(){
        
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void Hit(int damage, String status){
        if(status == "Freeze"){
            frozen = true;
        }
        else if(status == "Fire"){
            burning = true;
        }
        
        health -= damage;

    }

    public void Attack(Player player){
        if(burning){
            health -= 2;
        }
        
        player.getHit(attack);
        System.out.println("You got hit by " + this.name + " for " + attack + " hit points");
    }

    public void setAttack(int val){
        attack = val;
    }

    public int getAttack(){
        return attack;
    }

    public void setHealth(int val){
        health = val;
    }

    public int getHealth(){
        return health;
    }

    public boolean getFrozen(){
        return frozen;
    }

    public boolean getBurning(){
        return burning;
    }
}
