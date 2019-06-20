package ru.evenx.palindrome.interfaces;

import ru.evenx.palindrome.entities.Player;

import java.util.List;

/**
 * Интерфейс для работы с хранилищем данных об игроках и их выйгрышах
 */
public interface Storage {
    void save(Player player); // Запомнить ввод игрока
    Player load(String id); // Выгрузить данные об игроке
    List<Player> getBestPlayers(int count); // Показать count лучших игроков
}
