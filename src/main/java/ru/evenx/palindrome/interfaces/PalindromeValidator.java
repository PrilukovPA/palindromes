package ru.evenx.palindrome.interfaces;

/**
 * Интерфейс для проверки правильности палиндромов и обработки событий игрового ввода\вывода
 */
public interface PalindromeValidator {
    void validate(String playerId, String value); // Проверить правильность введенного палиндрома
    void setStorage(Storage storage); // Задать хранилище данных
    void setGameEventListener(GameEventListener gameEventListener); // Задать обработчик игровых ситуаций
    void showBestPlayers(); // Показать лучших игроков
}
