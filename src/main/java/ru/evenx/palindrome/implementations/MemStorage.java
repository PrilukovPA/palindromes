package ru.evenx.palindrome.implementations;

import ru.evenx.palindrome.entities.Player;
import ru.evenx.palindrome.interfaces.Storage;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Класс для работы с хранилищем данных об игроках и их выйгрышах
 */
public class MemStorage implements Storage {

    private ConcurrentMap<String, Player> storage = new ConcurrentHashMap<>();

    @Override
    public void save(Player player) {
        storage.put(player.getId(), player);
    }

    @Override
    public Player load(String id) {
        return storage.get(id);
    }

    @Override
    public List<Player> getBestPlayers(int count) {
        List<Player> retVal = storage.entrySet().stream()
                .sorted(Map.Entry.<String, Player>comparingByValue().reversed())
                .limit(count)
                .collect(ArrayList::new, (l, e) -> l. add(e.getValue()), List::addAll);
        return retVal;
    }
}
