package ru.evenx.palindrome.implementations;

import ru.evenx.palindrome.interfaces.GameEventListener;
import ru.evenx.palindrome.interfaces.PalindromeValidator;
import ru.evenx.palindrome.interfaces.Storage;

/**
 * Основной класс для проведения игры "Палиндромы"
 */
public class Game {
    private Storage storage = new MemStorage();
    private GameEventListener gameEventListener = new SimpleGameEventListener();
    private SimpleGameEventListener simpleGameEventListener = new SimpleGameEventListener();
    private PalindromeValidator palindromeValidator = new SimplePalindromeValidator();

    public Game() {
        palindromeValidator.setStorage(storage);
        palindromeValidator.setGameEventListener(simpleGameEventListener);
    }

    /**
     * Проверка введенного игроком палиндрома
     * @param playerId идентификатор игрока
     * @param palindrome палиндром
     */
    public void play(String playerId, String palindrome) {
        palindromeValidator.validate(playerId, palindrome);
    }

    /**
     * Показать лучших игроков
     */
    public void showBestPlayers() {
        palindromeValidator.showBestPlayers();
    }
}
