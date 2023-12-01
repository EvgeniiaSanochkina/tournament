import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    //ArrayList<Player> players = new ArrayList<>();
    HashMap<String, Integer> players = new HashMap<>();

    public void register(String playerName, int strength) {
        players.put(playerName, strength);
    }

    public int round(String playerName1, String playerName2) {

        int result = 0;
        int strength1 = 0;
        int strength2 = 0;

        if (players.get(playerName1) == null) {
            throw new NotRegisteredException("Нету такого игрока");
        }

        if (players.get(playerName2) == null) {
            throw new NotRegisteredException("Нету такого игрока");
        }

        for (String key : players.keySet()) {
            if (key == playerName1) {
                strength1 = players.get(key);
            }
            if (key == playerName2) {
                strength2 = players.get(key);
            }
        }

            if (strength1 > strength2) {
                result = 1;
            }
            if (strength1 < strength2) {
                result = 2;
            }
            return result;
        }
    }

