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
    private boolean alive = true;

    public ArrayList<ItemPair> items = new ArrayList<ItemPair>();
    public ArrayList<String> itemNames = new ArrayList<String>();
    public ArrayList<ArmorPair> armorList = new ArrayList<ArmorPair>();
    public ArrayList<String> armorNames = new ArrayList<String>();

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

    public Armor getArmor(){
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

    public boolean getAlive(){
        return alive;
    }

    public void setAlive(boolean status){
        alive = status;
    }

    public void LevelUp(){
        maxHealth += 50;
        health = maxHealth;
        attack += 2;
        level ++;
        nextLevel = level * 25;

        System.out.println("You leveled up!!");
        System.out.println("Level " + level);
        System.out.println("MAx Health + 50");
        System.out.println("Attack + 2");
        System.out.println("Exp till next level " + nextLevel);
    }

    public void Attack(Enemy villain){
        if(hasWeapon){
            villain.Hit(attack + weapon.getAttack(), status);
            status = "None";

            System.out.println("You hit" + villain.getName() + " for " + attack + weapon.getAttack() + " hit points");
        }
        else{
            villain.Hit(attack, status);
            status = "None";
            System.out.println("You hit" + villain.getName() + " for " + attack + " hit points");
        }
    }

    public List<ItemPair> getItems(){
        return items;
    }

    public List<String> getItemNames(){
        return itemNames;
    }

    public List<ArmorPair> getArmorList(){
        return armorList;
    }

    public List<String> getArmorNames(){
        return armorNames;
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
                System.out.println("You recieved 1 Potion!");
            }
            else if(item == "Fire"){
                itemNames.add("Fire");
                items.add(new ItemPair(new Fire(), 1));
                System.out.println("You recieved 1 Fire item!");
            }
            else if(item == "Freeze"){
                itemNames.add("Freeze");
                items.add(new ItemPair(new Freeze(), 1));
                System.out.println("You recieved 1 Freeze Item!");
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

                    System.out.println("You used 1 " + item);
                }
            }
        }

    }

    public void getHit(int damage){
        if(hasArmour){
            armor.Hit(this, damage);
            if(armor.getDurability() <= 0){
                for(int i = 0; i < armorList.size(); i ++){
                    if(armor.getType() == armorList.get(i).getKey().getType()){
                        if(armorNames.contains(armor.getType())){
                            armorList.get(i).setValue(armorList.get(i).getValue() - 1);
                            if(armorList.get(i).getValue() == 0){
                                armorNames.remove(armor.getType());
                                armorList.remove(i);
                            }
                            System.out.println("You're armor broke!");
                            equipArmor();
                        }
                    }
                }
            }
        }
        else{
            health -= damage;
        }
    }

    public void setArmor(String armor){
        
        if(armorNames.contains(armor)){
            for(int i = 0; i < armorList.size(); i ++){
                if(armor == armorList.get(i).getKey().getType()){
                    armorList.get(i).addValue(1);
                }
            }
        }
        else{
            if(armor == "Rags"){
                hasArmour = true;
                armorNames.add("Rags");
                this.armor = new Rags();
                armorList.add(new ArmorPair(this.armor, 1));
                System.out.println("You recieved Rags!");
                System.out.println("Durability: 5");
                System.out.println("Defense: 2");
            }
            else if(armor == "Steel"){
                hasArmour = true;
                armorNames.add("Steel");
                this.armor = new Steel();
                armorList.add(new ArmorPair(this.armor, 1));
                System.out.println("You recieved Steel Armor!");
                System.out.println("Durability: 20");
                System.out.println("Defense: 10"); 
            }
        }
    }

    public void equipArmor(){
        if(armorList.size() > 0){
            armor.setDurability(armor.getMaxDurability());;
            System.out.println("Now wearing " + armor.getType() + " armor");
        }
    }

}


