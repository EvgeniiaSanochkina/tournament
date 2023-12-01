import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test {

    Player player1 = new Player(1, "ok", 10);
    Player player2 = new Player(2, "ik", 7);
    Player player3 = new Player(3, "uk", 13);
    Player player4 = new Player(4, "pok", 7);
    Player player5 = new Player(5, "suk", 27);

    Game game = new Game();

    @org.junit.jupiter.api.Test
    public void shouldFindFirstStronger() {
        game.register(player1);
        game.register(player2);
        int actual = game.round("ok", "ik");
        int expected = 1;
        Assertions.assertEquals(expected, actual);

    }

    @org.junit.jupiter.api.Test
    public void shouldFindSecondStronger() {
        game.register(player3);
        game.register(player5);
        int actual = game.round("uk", "suk");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void shouldFindBothEqual() {
        game.register(player2);
        game.register(player4);
        int actual = game.round("ik", "pok");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void shouldThrowExc1() {
        game.register(player2);
        game.register(player4);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("suk", "pok");
        });
    }

    @org.junit.jupiter.api.Test
    public void shouldThrowExc2() {
        game.register(player2);
        game.register(player4);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("ik", "suk");
        });
    }



}
