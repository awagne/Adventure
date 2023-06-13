package src;

import static org.junit.Assert.*;

import java.util.Collections;

import org.junit.Test;

public class PlayerTest {
    
    @Test
    public void LevelUpTest(){
        Player player = new Player();

        assertEquals(1, player.getLevel());
        assertEquals(25, player.getExp());
        assertEquals(100, player.getHealth());
        assertEquals(1, player.getAttack());

        player.LevelUp();

        assertEquals(2, player.getLevel());
        assertEquals(50, player.getExp());
        assertEquals(150, player.getHealth());
        assertEquals(3, player.getAttack());
    }

    @Test
    public void AttackTest(){
        Player player = new Player();
        Enemy enemy = new Enemy();

        assertEquals(100, enemy.getHealth());
        player.Attack(enemy);
        assertEquals(99, enemy.getHealth());
    }

    @Test
    public void ItemTest(){
        Player player = new Player();

        assertEquals(Collections.emptyList(), player.getItems());
        player.getItem("Potion");
        assertEquals(1, player.getItems().size());
        assertEquals("Potion", player.getItemNames().get(0));

        player.useItem("Potion");
        assertEquals(Collections.emptyList(), player.getItems());
        assertEquals(0, player.getItemNames().size());
    }

    @Test
    public void ArmorTest(){
        Player player = new Player();
        Enemy enemy = new Enemy();

        assertEquals(Collections.emptyList(), player.getArmorList());
        player.setArmor("Rags");
        assertEquals(1, player.getArmorList().size());
        assertEquals("Rags", player.getArmorNames().get(0));
        assertEquals(100, player.getHealth());

        enemy.setAttack(5);
        enemy.Attack(player);
        enemy.Attack(player);
        enemy.Attack(player);
        enemy.Attack(player);
        enemy.Attack(player);
        
        assertEquals(85, player.getHealth());
        assertEquals(0,player.getArmor().getDurability());
        assertEquals(Collections.emptyList(), player.getArmorList());
        assertEquals(0, player.getArmorNames().size());

        player.setArmor("Rags");
        player.setArmor("Rags");
        assertEquals(1, player.getArmorList().size());
        assertEquals(2, player.getArmorList().get(0).getValue());
        assertEquals("Rags", player.getArmorNames().get(0));
        assertEquals(85, player.getHealth());

        enemy.setAttack(5);
        enemy.Attack(player);
        enemy.Attack(player);
        enemy.Attack(player);
        enemy.Attack(player);
        enemy.Attack(player);

        assertEquals(70, player.getHealth());
        assertEquals(5,player.getArmor().getDurability());
        assertEquals("Rags", player.getArmorNames().get(0));
        assertEquals(1, player.getArmorList().get(0).getValue());
    }
}
