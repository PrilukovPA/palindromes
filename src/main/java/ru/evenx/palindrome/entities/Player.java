package ru.evenx.palindrome.entities;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Данные об игроке: его идентификатор, введенные палиндромы и т.д.
 */
public class Player implements Comparable<Player> {

    private String id;
    private Set<String> palindromes = new HashSet<>();
    private int lastScores;
    private Timestamp lastSuccessTime;

    public Timestamp getLastSuccessTime() {
        return lastSuccessTime;
    }

    public Player(String id) { this.id = id; }

    public Player(String id, String palindrome) {
        this.id = id;
        addPalindrome(palindrome);
    }

    /**
     * Возвращает количество выйгранных очков за последний сохраненный палиндром
     */
    public int getLastScores() { return lastScores; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public Set<String> getPalindromes() { return Collections.unmodifiableSet(palindromes); }

    /**
     * Возвращает общее количество очков за все сохраненные палиндромы
     */
    public int getTotalScores() {
        return palindromes.stream().mapToInt(i -> i.length()).sum();
    }

    public void addPalindrome(String value) {
        lastScores = computeScores(value);
        lastSuccessTime = new Timestamp(System.currentTimeMillis());
        palindromes.add(value);
    }

    @Override
    public String toString() {
        return id + ": " + getTotalScores();
    }

    private int computeScores(String value) { return value.length(); }

    @Override
    public int compareTo(Player player) {
        int thisScores = getTotalScores();
        int thatScores = player.getTotalScores();
        if (thisScores != thatScores) {
            return thisScores - thatScores;
        } else {
            return getLastSuccessTime().compareTo(player.getLastSuccessTime());
        }
    }
}
