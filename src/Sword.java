package src;

public class Sword extends Weapon{

    public Sword(Player player){
        SetType("Sword");
        setAttack(player, 5, .2);
    }

}
