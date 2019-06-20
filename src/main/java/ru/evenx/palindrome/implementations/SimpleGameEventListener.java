package ru.evenx.palindrome.implementations;

import ru.evenx.palindrome.entities.Player;
import ru.evenx.palindrome.interfaces.GameEventListener;

import java.util.List;

/**
 * Класс обработчика игровых ситуаций
 */
public class SimpleGameEventListener implements GameEventListener {
    @Override
    public void onSuccess(Player player) {
        System.out.println("[" + player.getId() + "] Success! You scores " + player.getLastScores() + "/" + player.getTotalScores());
    }

    @Override
    public void onFail() {
        System.out.println("Not palindrome!");
    }

    @Override
    public void onDuplicatedValue(Player player) {
        System.out.println("[" + player.getId() + "] Duplicated value!");
    }

    @Override
    public void onShowBestPlayers(List<Player> bestPlayers) {
        System.out.println("BEST PLAYERS");
        bestPlayers.forEach(player -> System.out.println(player));
    }
}
