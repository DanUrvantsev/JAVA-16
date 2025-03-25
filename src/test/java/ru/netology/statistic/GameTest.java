package ru.netology.statistic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void firstPlayerWins() {
        Game game = new Game();
        game.register(new Player(1, "Богатырь", 20));
        game.register(new Player(2, "Слабочок", 10));
        assertEquals(1, game.round("Богатырь", "Слабочок"));
    }

    @Test
    void secondPlayerWins() {
        Game game = new Game();
        game.register(new Player(1, "Новичок", 10));
        game.register(new Player(2, "Профи", 20));
        assertEquals(2, game.round("Новичок", "Профи"));
    }

    @Test
    void draw() {
        Game game = new Game();
        game.register(new Player(1, "Игрок1", 10));
        game.register(new Player(2, "Игрок2", 10));
        assertEquals(0, game.round("Игрок1", "Игрок2"));
    }

    @Test
    void firstPlayerNotRegistered() {
        Game game = new Game();
        game.register(new Player(2, "Петя", 15));
        assertThrows(NotRegisteredException.class, () -> game.round("Вася", "Петя"));
    }

    @Test
    void secondPlayerNotRegistered() {
        Game game = new Game();
        game.register(new Player(1, "Маша", 10));
        assertThrows(NotRegisteredException.class, () -> game.round("Маша", "Даша"));
    }

    @Test
    void bothPlayersNotRegistered() {
        Game game = new Game();
        assertThrows(NotRegisteredException.class, () -> game.round("Коля", "Оля"));
    }
}