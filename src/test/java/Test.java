import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test {

    String playerName1 = "ok";
    int strength1 = 10;

    String playerName2 = "ik";
    int strength2 = 7;

    String playerName3 = "uk";
    int strength3 = 13;

    String playerName4 = "pok";
    int strength4 = 7;

    String playerName5 = "suk";
    int strength5 = 27;


    Game game = new Game();

    @org.junit.jupiter.api.Test
    public void shouldFindFirstStronger() {
        game.register(playerName1, strength1);
        game.register(playerName2, strength2);
        int actual = game.round("ok", "ik");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void shouldFindSecondStronger() {
        game.register(playerName3, strength3);
        game.register(playerName5, strength5);
        int actual = game.round("uk", "suk");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void shouldFindBothEqual() {
        game.register(playerName2, strength2);
        game.register(playerName4, strength4);
        int actual = game.round("ik", "pok");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    public void shouldThrowExc1() {
        game.register(playerName2, strength2);
        game.register(playerName4, strength4);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("suk", "pok");
        });
    }

    @org.junit.jupiter.api.Test
    public void shouldThrowExc2() {
        game.register(playerName2, strength2);
        game.register(playerName4, strength4);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("ik", "suk");
        });
    }


}
