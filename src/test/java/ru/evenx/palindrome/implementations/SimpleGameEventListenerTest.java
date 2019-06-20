package ru.evenx.palindrome.implementations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.evenx.palindrome.entities.Player;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SimpleGameEventListenerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void onSuccess() {
        SimpleGameEventListener listener = new SimpleGameEventListener();
        Player player = new Player("test", "101");
        listener.onSuccess(player);
        assertEquals("[test] Success! You scores 3/3\r\n", outContent.toString());
    }

    @Test
    public void onFail() {
        SimpleGameEventListener listener = new SimpleGameEventListener();
        listener.onFail();
        assertEquals("Not palindrome!\r\n", outContent.toString());
    }

    @Test
    public void onDuplicatedValue() {
        SimpleGameEventListener listener = new SimpleGameEventListener();
        Player player = new Player("test", "101");
        listener.onDuplicatedValue(player);
        assertEquals("[test] Duplicated value!\r\n", outContent.toString());
    }

    @Test
    public void onShowBestPlayers() {
        SimpleGameEventListener listener = new SimpleGameEventListener();
        Player player = new Player("test", "101");
        List<Player> bestPlayers = new ArrayList<>();
        bestPlayers.add(player);
        listener.onShowBestPlayers(bestPlayers);
        assertEquals("BEST PLAYERS\r\ntest: 3\r\n", outContent.toString());
    }
}