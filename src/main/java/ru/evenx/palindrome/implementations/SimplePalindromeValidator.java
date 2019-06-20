package ru.evenx.palindrome.implementations;

import ru.evenx.palindrome.entities.Player;
import ru.evenx.palindrome.interfaces.GameEventListener;
import ru.evenx.palindrome.interfaces.PalindromeValidator;
import ru.evenx.palindrome.interfaces.Storage;

public class SimplePalindromeValidator implements PalindromeValidator {

    private static final int BEST_PLAYERS_COUNT = 5; // Размер топа игроков
    private Storage storage;
    private GameEventListener gameEventListener;

    private void onSuccess(Player player) {
        if (gameEventListener != null) gameEventListener.onSuccess(player);
    }

    private void onDuplicatedValue(Player player) {
        if (gameEventListener != null) gameEventListener.onDuplicatedValue(player);
    }

    private void onFail() {
        if (gameEventListener != null) gameEventListener.onFail();
    }

    /**
     * Проверяет, является ли строка палиндромом. Примем минимальную длину палидрома в 1 символ.
     */
    public static boolean isPalindrome(String text) {
        if (text == null || text.isEmpty())
            return false;
        String clearText = text.replaceAll("\\W","");
        StringBuilder stringBuilder = new StringBuilder(clearText);
        return clearText.equalsIgnoreCase(stringBuilder.reverse().toString());
    }

    @Override
    public void validate(String playerId, String value) {
        if (isPalindrome(value)) {
            Player player = storage.load(playerId);
            if (player == null) {
                player = new Player(playerId, value);
                storage.save(player);
                onSuccess(player);
            } else {
                if (player.getPalindromes().contains(value)) {
                    onDuplicatedValue(player);
                } else {
                    player.addPalindrome(value);
                    onSuccess(player);
                }
            }
        } else {
            onFail();
        }
    }

    @Override
    public void showBestPlayers() {
        if (gameEventListener != null) gameEventListener.onShowBestPlayers(storage.getBestPlayers(BEST_PLAYERS_COUNT));
    }

    @Override
    public void setGameEventListener(GameEventListener gameEventListener) {
        this.gameEventListener = gameEventListener;
    }

    @Override
    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
