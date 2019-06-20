package ru.evenx.palindrome.implementations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class GameTest {

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
    public void play() {
        Game game = new Game();
        game.play("Pavel", "Some men interpret nine memos");
        game.play("Pavel", "Some men interpret nine memos");
        game.play("Pavel", "123");
        game.play("Roman", "Some men interpret nine memos");
        game.play("Roman", "Some men interpret nine memos");
        game.play("Roman", "123");

        assertEquals("[Pavel] Success! You scores 29/29\r\n" +
                "[Pavel] Duplicated value!\r\n" +
                "Not palindrome!\r\n" +
                "[Roman] Success! You scores 29/29\r\n" +
                "[Roman] Duplicated value!\r\n" +
                "Not palindrome!\r\n", outContent.toString());
    }

    @Test
    public void showBestPlayers() {
        Game game = new Game();
        game.play("Pavel", "Madam, I'm Adam!");
        try {
            Thread.sleep(100);
            game.play("Roman", "Madam, I'm Adam!");
            Thread.sleep(100);
            game.play("Evgenij", "Madam, I'm Adam!");
            Thread.sleep(100);
            game.play("Maxim", "Madam, I'm Adam!");
            Thread.sleep(100);
            game.play("Anton", "Madam, I'm Adam!");
            Thread.sleep(100);
            game.play("Dmitrij", "Madam, I'm Adam!");
            Thread.sleep(100);

            game.play("Roman", "1001");
            Thread.sleep(100);
            game.play("Pavel", "101");
            Thread.sleep(100);
            game.play("Anton", "1");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        game.showBestPlayers();

        assertEquals("[Pavel] Success! You scores 16/16\r\n" +
                "[Roman] Success! You scores 16/16\r\n" +
                "[Evgenij] Success! You scores 16/16\r\n" +
                "[Maxim] Success! You scores 16/16\r\n" +
                "[Anton] Success! You scores 16/16\r\n" +
                "[Dmitrij] Success! You scores 16/16\r\n" +
                "[Roman] Success! You scores 4/20\r\n" +
                "[Pavel] Success! You scores 3/19\r\n" +
                "[Anton] Success! You scores 1/17\r\n" +
                "BEST PLAYERS\r\n" +
                "Roman: 20\r\n" +
                "Pavel: 19\r\n" +
                "Anton: 17\r\n" +
                "Dmitrij: 16\r\n" +
                "Maxim: 16\r\n", outContent.toString());
    }
}