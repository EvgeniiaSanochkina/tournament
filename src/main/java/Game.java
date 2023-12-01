import java.util.ArrayList;

public class Game {
    ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {

        int result = 0;
        Player player1 = null;
        Player player2 = null;

        for (Player player : players) {
            if (player.getName() == playerName1) {
                player1 = player;
            }
            if (player.getName() == playerName2) {
                player2 = player;
            }
        }

        if (player1 == null) {
            throw new NotRegisteredException("Нету такого игрока");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Нету такого игрока");
        }
        if (player1.getStrength() > player2.getStrength()) {
            result = 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            result = 2;
        }

        return result;
    }
}
