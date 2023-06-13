package src;

public class Weapon {

    private String type = "";
    private int attack = 0;
    
    public Weapon(){

    }

    public void SetType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public void setAttack(Player player, int val, double percent){
        if((int)(player.getAttack() * percent) > val){
            attack = (int)(player.getAttack() * percent);
        }
        else{
            attack = val;
        }
    }

    public Integer getAttack(){
        return attack;
    }


}
