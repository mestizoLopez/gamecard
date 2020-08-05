package org.example.service;

import org.example.dao.Game;
import org.example.entity.Card;
import org.example.entity.Player;
import org.example.exception.NoHandException;

import java.util.*;

public class GreatestValueGame implements Game {

    private static Game instance;
    private Deck deck;

    private GreatestValueGame() {
        deck = new Deck();
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new GreatestValueGame();
        }
        return instance;
    }

    @Override
    public void close() throws Exception {
        System.out.println("Cleaning up instance");
        instance = null;
    }

    @Override
    public void dealCard(Player player) throws Exception {
        List<Card> hand = Optional.ofNullable(player.getHand()).orElseThrow(() -> new NoHandException("Player has to choose their cards"));
        player.getHand().add(deck.dealCard());
    }

    @Override
    public void printWinner(List<Player> playerList) throws Exception {
        if (playerList.size() < 2) {
            System.out.println("At least this game needs 2 players");
            return;
        }

        ListIterator<Player> playerIterator = playerList.listIterator();
        Player winnerPlayer = null;
        short tieCounter = 0;

        while (playerIterator.hasNext()) {

            if (playerList.size() >= 2) {

                Card card = null;
                Card nextCard = null;
                final Player player = playerList.get(0);
                final Player nextPlayer = playerList.get(1);

                final List<Card> hand = Optional.ofNullable(player.getHand()).orElseThrow(() -> new NoHandException("Player has to choose their cards"));
                final List<Card> nextHand = Optional.ofNullable(nextPlayer.getHand()).orElseThrow(() -> new NoHandException("Player has to choose their cards"));

                if (!hand.isEmpty() && !nextHand.isEmpty()) {
                    card = hand.get(0);
                    nextCard = nextHand.get(0);
                }
                if (card.getValue() > nextCard.getValue()) {
                    winnerPlayer = player;
                    playerList.remove(nextPlayer);
                } else if (card.getValue() < nextCard.getValue()) {
                    winnerPlayer = nextPlayer;
                    playerList.remove(player);
                    if (tieCounter > 0) {
                        tieCounter--;
                    }
                } else {
                    tieCounter++;
                    playerList.remove(nextPlayer);
                }
            } else {
                break;
            }

        }

        String result = tieCounter > 0 ? "It's tie" : "Player " + winnerPlayer.getNumber() + " wins";

        System.out.println(result);

    }


}
