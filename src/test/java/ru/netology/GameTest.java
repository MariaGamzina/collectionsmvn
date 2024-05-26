package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class GameTest {

    Game game = new Game();
    ArrayList<Player> playersList = new ArrayList<>();
    Player player1 = new Player(11, "Иван Петров", 10);
    Player player2 = new Player(14, "Сергей Сидоров", 8);
    Player player3 = new Player(23, "Марина Новикова", 12);
    Player player4 = new Player(25, "Константин Лазутин", 6);
    Player player5 = new Player(42, "Екатерина Пушкина", 12);


    @Test
    public void shouldRoundPlayerNameOneWin() {
        Game game = new Game();
        game.register(player1);
        game.register(player3);


        int expected = 1;
        int actual = game.round("Марина Новикова", "Иван Петров");
        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void shouldRoundPlayerNameTwoWin() {
        Game game = new Game();
        game.register(player1);
        game.register(player3);


        int expected = 2;
        int actual = game.round("Иван Петров", "Марина Новикова");
        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void shouldRoundPlayerBothWin() {
        Game game = new Game();
        game.register(player5);
        game.register(player3);


        int expected = 0;
        int actual = game.round("Екатерина Пушкина", "Марина Новикова");
        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void shouldRoundPlayerNoRegisterTwo() {
        Game game = new Game();

        game.register(player3);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Марина Новикова", "Иван Иванов"));


    }

    @Test
    public void shouldRoundPlayerNoRegisterOne() {
        Game game = new Game();

        game.register(player3);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Иван Иванов", "Марина Новикова"));


    }


}

