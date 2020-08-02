package org.example.core;

public class Game implements AutoCloseable {
    private Game() {
        deck = new Deck();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Cleaning up instance");
        instance = null;
    }

    public void dealCard(Player p) {
        p.hand.add(deck.dealCard());
    }

    public void printWinner(Player p1, Player p2) {
        Card c1 = null;
        Card c2 = null;
        for (Card c : p1.hand) {
            if (c1 == null) {
                c1 = c;
            } else if (c.value > c1.value)  {
                 c1 = c;
            }
        }
        for (Card c : p2.hand) {
            if (c2 == null) {
                c2 = c;
            } else if (c.value > c2.value)  {
                c2 = c;
            }
        }
        if (c1.value > c2.value) {
            System.out.println("Player 1 wins");
        } else if (c2.value > c1.value) {
            System.out.println("Player 2 wins");
        } else {
            System.out.println("It's a tie");
        }
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    private static Game instance;
    private Deck deck;
}
