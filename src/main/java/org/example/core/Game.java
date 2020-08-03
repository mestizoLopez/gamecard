package org.example.core;

import org.example.entity.Card;
import org.example.entity.Player;
import org.example.exception.NoHandException;
import org.example.service.Deck;

import java.util.Collections;
import java.util.Optional;

public class Game implements AutoCloseable {

    private static Game instance;
    private Deck deck;

    private Game() {
        deck = new Deck();
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    @Override
    public void close() throws Exception {
        System.out.println("Cleaning up instance");
        instance = null;
    }

    public void dealCard(Player p) throws Exception {
        p.getHand().add(deck.dealCard());
    }

    public void printWinner(Player p1, Player p2) throws Exception {

        Collections.sort(p1.getHand());
        Collections.sort(p2.getHand());
        if (!p1.getHand().isEmpty() && !p2.getHand().isEmpty()) {
            Card c1 = Optional.ofNullable(p1.getHand().get(0)).orElseThrow(()->new NoHandException(""));
            Card c2 = Optional.ofNullable(p2.getHand().get(0)).orElseThrow(()->new NoHandException(""));

            if (c1.getValue() > c2.getValue()) {
                System.out.println("Player 1 wins " + c1.getSuite() + " " + c1.getValue());
            } else if (c2.getValue() > c1.getValue()) {
                System.out.println("Player 2 wins " + c2.getSuite() + " " + c2.getValue());
            } else {
                System.out.println(c1.getSuite() + " " + c1.getValue() + " " + c2.getSuite() + " " + c2.getValue());
                System.out.println("It's a tie");
            }
        }else{
            throw new Exception("Players has to choose their cards");
        }

    }

}
