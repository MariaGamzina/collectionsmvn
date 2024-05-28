package ru.netology;

import java.util.*;

public class Game {

    HashMap<String, Player> map = new HashMap<>();


    public void register(String key, Player player) {
        map.put(key, player);
    }


    public Player findByName(String name) {
        for (String key : map.keySet()) {
            Player player = map.get(key);
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player name1 = findByName(playerName1);
        Player name2 = findByName(playerName2);

        if (findByName(playerName1) == null) {
            throw new NotRegisteredException(
                    "Player" + playerName1 + "is not registered!"
            );
        } else if (findByName(playerName2) == null) {
            throw new NotRegisteredException(
                    "Player" + playerName2 + "is not registered!"
            );
        }
        if (name1.getStrength() > name2.getStrength()) {
            return 1;
        } else if (name1.getStrength() < name2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
