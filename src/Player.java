package src;
import java.util.*;

public class Player {
    private int level = 1;
    private int nextLevel = 25;
    private int maxHealth = 100;
    private int health = 100;
    private int attack = 1;
    private boolean hasWeapon = false;
    private Weapon weapon;
    private String status = "None";
    private boolean hasArmour = false;
    private Armor armor;
    public ArrayList<ItemPair> items = new ArrayList<ItemPair>();
    public ArrayList<String> itemNames = new ArrayList<String>();

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

    public int getMaxHealth(){
        return maxHealth;
    }

    public void setHealth(int value){
        health = value;
    }

    public int getAttack(){
        return attack;
    }

    public Armor getArmour(){
        return armor;
    }

    public boolean hasWeapon(){
        return hasWeapon;
    }

    public Weapon getWeapon(){
        return weapon;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void LevelUp(){
        maxHealth += 50;
        health = maxHealth;
        attack += 2;
        level ++;
        nextLevel = level * 25;
    }

    public void Attack(Enemy villain){
        if(hasWeapon){
            villain.Hit(attack + weapon.getAttack(), status);
            status = "None";
        }
        else{
            villain.Hit(attack, status);
            status = "None";
        }
    }

    public List<ItemPair> getItems(){
        return items;
    }

    public List<String> getItemNames(){
        return itemNames;
    }

    public void getItem(String item){
        if(itemNames.contains(item)){
            for(int i = 0; i < items.size(); i ++){
                if(item == items.get(i).getKey().getName()){
                    items.get(i).setValue(items.get(i).getValue() + 1);
                }
            }
        }
        else{
            if(item == "Potion"){
                itemNames.add("Potion");
                items.add(new ItemPair(new Potion(), 1));
            }
            else if(item == "Fire"){
                itemNames.add("Fire");
                items.add(new ItemPair(new Fire(), 1));
            }
            else if(item == "Freeze"){
                itemNames.add("Freeze");
                items.add(new ItemPair(new Freeze(), 1));
            }
        }
    }

    public void useItem(String item){

        for(int i = 0; i < items.size(); i ++){
            if(item == items.get(i).getKey().getName()){
                if(itemNames.contains(item)){
                    items.get(i).setValue(items.get(i).getValue() - 1);
                    items.get(i).getKey().useItem(this);
                    if(items.get(i).getValue() == 0){
                        itemNames.remove(item);
                        items.remove(i);
                    }
                }
            }
        }

    }

    public void getHit(int damage){
        if(hasArmour){
            armor.Hit(this, damage);
        }
        else{
            health -= damage;
        }
    }

}
