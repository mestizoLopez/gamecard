package org.example.service;

import org.example.dao.Game;
import org.example.entity.Card;
import org.example.entity.Player;
import org.example.exception.NoHandException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GreatestValueTest {

    private Game game;
    private List<Player> playerList;
    private Player player;

    @Test
    public void dealCard() throws Exception {

        game = GreatestValueGame.getInstance();
        player = new Player(1);
        List<Card> hand = player.getHand();
        game.dealCard(player);

        assertTrue(hand.size()>0);

        game.close();
    }

    @Test
    public void dealExpectedNoHandExceptionTest() throws Exception {

        game = GreatestValueGame.getInstance();
        player = new Player(1);
        player.setHand(null);

        Assertions.assertThrows(NoHandException.class,()->{
           game.dealCard(player);
        });

        game.close();
    }

    @Test
    public void lessThan2PlayersTest() throws Exception {

        game = GreatestValueGame.getInstance();
        playerList = new ArrayList();
        playerList.add(new Player(1));
        game.printWinner(playerList);

        assertTrue(playerList.size()<2);

        game.close();
    }

    @Test
    public void playerExpectedNoHandExceptionTest() throws Exception {

        game = GreatestValueGame.getInstance();
        playerList = new ArrayList();
        Player player1 = new Player(1);
        Player player2 = new Player(1);

        player1.setHand(null);

        playerList.add(player1);
        playerList.add(player2);
        assertThrows(NoHandException.class,()->{
            game.printWinner(playerList);
        });

        game.close();

    }

    @Test
    public void nextPlayerExpectedNoHandExceptionTest() throws Exception {

        game = GreatestValueGame.getInstance();
        playerList = new ArrayList();
        Player player1 = new Player(1);
        Player player2 = new Player(1);

        player2.setHand(null);

        playerList.add(player1);
        playerList.add(player2);
        assertThrows(NoHandException.class,()->{
            game.printWinner(playerList);
        });

        game.close();

    }

    @Test
    public void printWinner() throws Exception {

        game = GreatestValueGame.getInstance();
        playerList = new ArrayList();
        Player player1 = new Player(1);
        Player player2 = new Player(1);

        for (int i = 1; i <= 5; i++) {
            playerList.add(new Player(i));
        }

        for (int i = 0; i < 5; i++) {
            for(Player player: playerList){
                game.dealCard(player);
            }
        }

        game.printWinner(playerList);
        game.close();

    }

}