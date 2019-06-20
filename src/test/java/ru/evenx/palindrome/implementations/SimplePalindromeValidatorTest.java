package ru.evenx.palindrome.implementations;

import org.junit.Test;
import ru.evenx.palindrome.entities.Player;
import ru.evenx.palindrome.interfaces.GameEventListener;

import java.util.List;

import static org.junit.Assert.*;

public class SimplePalindromeValidatorTest {

    @Test
    public void isPalindrome() {
        assertTrue(SimplePalindromeValidator.isPalindrome("101"));
        assertFalse(SimplePalindromeValidator.isPalindrome("123"));
        assertFalse(SimplePalindromeValidator.isPalindrome(""));
        assertFalse(SimplePalindromeValidator.isPalindrome(null));
    }

    @Test
    public void validate() {
        MemStorage storage = new MemStorage();
        SimplePalindromeValidator validator = new SimplePalindromeValidator();
        validator.setStorage(storage);
        validator.validate("test", "101");
        validator.validate("test", "010");
        validator.validate("test", "123");
        validator.validate("test", null);
        validator.validate(null, "123");
        assertEquals(storage.load("test").getId(), "test");
        assertEquals(storage.load("test").getPalindromes().size(), 2);
        assertEquals(storage.load("test").getTotalScores(), 6);
    }

    @Test
    public void showBestPlayers() {
        MemStorage storage = new MemStorage();
        SimplePalindromeValidator validator = new SimplePalindromeValidator();
        validator.setStorage(storage);
        validator.setGameEventListener(new GameEventListener() {
            @Override
            public void onFail() {

            }

            @Override
            public void onSuccess(Player player) {

            }

            @Override
            public void onDuplicatedValue(Player player) {

            }

            @Override
            public void onShowBestPlayers(List<Player> bestPlayers) {
                assertEquals(bestPlayers.size(), 5);
                assertEquals(bestPlayers.get(0).getId(), "test6");
                assertEquals(bestPlayers.get(4).getId(), "test2");
            }
        });
        validator.validate("test1", "101");
        validator.validate("test2", "1001");
        validator.validate("test3", "10001");
        validator.validate("test4", "100001");
        validator.validate("test5", "1000001");
        validator.validate("test6", "10000001");
        validator.showBestPlayers();
    }

    @Test
    public void setGameEventListener() {
        MemStorage storage = new MemStorage();
        SimplePalindromeValidator validator = new SimplePalindromeValidator();
        validator.setStorage(storage);
        final boolean[] b = {false};
        validator.setGameEventListener(new GameEventListener() {
            @Override
            public void onFail() {
                b[0] = true;
            }

            @Override
            public void onSuccess(Player player) {
                b[0] = true;
            }

            @Override
            public void onDuplicatedValue(Player player) {
                b[0] = true;
            }

            @Override
            public void onShowBestPlayers(List<Player> bestPlayers) {
                b[0] = true;
            }
        });
        validator.validate("test1", "101");
        assertTrue(b[0]);
    }

    @Test
    public void setStorage() {
        MemStorage storage = new MemStorage();
        SimplePalindromeValidator validator = new SimplePalindromeValidator();
        validator.setStorage(storage);
        validator.validate("test1", "101");
        assertTrue(storage.load("test1") != null);
    }
}