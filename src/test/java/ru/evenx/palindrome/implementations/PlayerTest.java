package ru.evenx.palindrome.implementations;

import org.junit.Test;
import ru.evenx.palindrome.entities.Player;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void getLastScores() {
        Player player = new Player("test", "101101");
        assertEquals(player.getLastScores(), 6);
        player.addPalindrome("101");
        assertEquals(player.getLastScores(), 3);
    }

    @Test
    public void getId() {
        Player player = new Player("test", "101101");
        assertEquals(player.getId(), "test");
    }

    @Test
    public void setId() {
        Player player  = new Player(null);
        player.setId("test");
        assertEquals(player.getId(), "test");
    }

    @Test
    public void getPalindromes() {
        Player player = new Player("test", "101101");
        player.addPalindrome("101");
        assertTrue(player.getPalindromes().contains("101101"));
        assertTrue(player.getPalindromes().contains("101"));
        try {
            player.getPalindromes().add("111");
            fail();
        } catch (Exception e) {

        }
    }

    @Test
    public void getTotalScores() {
        Player player = new Player("test", "101101");
        player.addPalindrome("101");
        assertEquals(player.getTotalScores(), 9);
    }

    @Test
    public void addPalindrome() {
        Player player = new Player("test", "101101");
        player.addPalindrome("101");
        assertEquals(player.getLastScores(), 3);
        assertEquals(player.getPalindromes().size(), 2);
    }

    @Test
    public void toString1() {
        Player player = new Player("test", "101101");
        assertTrue(player.toString().equals("test: 6"));
    }

    @Test
    public void compareTo() {
        Player player1 = new Player("test1", "101101");
        Player player2 = new Player("test2", "101");
        Player player3 = new Player("test3", "010");
        assertTrue(player1.compareTo(player2) > 1);
        assertTrue(player2.compareTo(player1) < 1);
        assertTrue(player2.compareTo(player3) == 0);
    }
}