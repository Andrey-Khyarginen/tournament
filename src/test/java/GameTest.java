import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void testWhenFirstPlayerStronger() {
        Game game = new Game();
        Player player1 = new Player(1, "Kiril", 100);
        Player player2 = new Player(2, "Alesha", 10);
        game.register(player1);
        game.register(player2);
        int actual = game.round("Kiril", "Alesha");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSecondPlayerStronger() {
        Game game = new Game();
        Player player1 = new Player(1, "Kiril", 100);
        Player player2 = new Player(2, "Alesha", 1000);
        game.register(player1);
        game.register(player2);
        int actual = game.round("Kiril", "Alesha");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testStrong() {
        Game game = new Game();
        Player player1 = new Player(1, "Kiril", 1000);
        Player player2 = new Player(2, "Alesha", 1000);
        game.register(player1);
        game.register(player2);
        int actual = game.round("Kiril", "Alesha");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testException() {
        Game game = new Game();
        Player player1 = new Player(1, "Kiril", 1000);
        Player player2 = new Player(2, "Alesha", 1000);
        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Kiril", "Danil")
        );
    }
    @Test
    public void testException2() {
        Game game = new Game();
        Player player1 = new Player(1, "Kiril", 1000);
        Player player2 = new Player(2, "Alesha", 1000);
        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Vova", "Danil")
        );
    }
}