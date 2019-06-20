package ru.evenx.palindrome.implementations;

import org.junit.Test;
import ru.evenx.palindrome.entities.Player;

import java.util.List;

import static org.junit.Assert.*;

public class MemStorageTest {

    @Test
    public void save() {
        MemStorage memStorage = new MemStorage();
        Player player1 = new Player("test1", "101");
        Player player2 = new Player("test2", "101");
        memStorage.save(player1);
        memStorage.save(player2);
        assertEquals(memStorage.load("test1"), player1);
        assertEquals(memStorage.load("test2"), player2);
    }

    @Test
    public void load() {
        MemStorage memStorage = new MemStorage();
        Player player = memStorage.load("");
        assertEquals(player, null);
    }

    @Test
    public void getBestPlayers() {
        MemStorage memStorage = new MemStorage();
        memStorage.save(new Player("test1", "101"));
        memStorage.save(new Player("test2", "1001"));
        memStorage.save(new Player("test3", "10001"));
        memStorage.save(new Player("test4", "100001"));
        memStorage.save(new Player("test5", "1000001"));
        memStorage.save(new Player("test6", "10000001"));
        int cnt = 5;
        List<Player> list = memStorage.getBestPlayers(cnt);
        assertEquals(list.size(), cnt);
        assertEquals(list.get(0).getId(), "test6");
        assertEquals(list.get(cnt - 1).getId(), "test2");
    }
}