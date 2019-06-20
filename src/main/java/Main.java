import ru.evenx.palindrome.implementations.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.play("Pavel", "Madam, I'm Adam!");
        game.play("Roman", "Madam, I'm Adam!");
        game.play("Evgenij", "Madam, I'm Adam!");
        game.play("Maxim", "Madam, I'm Adam!");
        game.play("Anton", "Madam, I'm Adam!");
        game.play("Dmitrij", "Madam, I'm Adam!");

        game.play("Roman", "1001");
        game.play("Pavel", "101");
        game.play("Anton", "1");

        game.showBestPlayers();
    }
}
