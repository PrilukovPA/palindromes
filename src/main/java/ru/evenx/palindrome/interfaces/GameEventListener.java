package ru.evenx.palindrome.interfaces;

import ru.evenx.palindrome.entities.Player;

import java.util.List;

/**
 * Интерфейс обработчика игровых ситуаций
 */
public interface GameEventListener {
    void onFail(); // Введеная фраза не является палиндромом
    void onSuccess(Player player); // Палиндром успешно принят
    void onDuplicatedValue(Player player); // Введен существующий палиндром
    void onShowBestPlayers(List<Player> bestPlayers); // Запрошен вывод лучших игроков
}
