package org.example.core;

import java.util.ArrayList;

public class Deck {
    public ArrayList<Card> deck = new ArrayList<Card>();
    public ArrayList<Card> delt = new ArrayList<Card>();

    public Deck() {
        for(int i = 1 ; i <= 13 ; i++){
            deck.add(new Card(i,Suite.CLUBS));
            deck.add(new Card(i,Suite.DIAMONDS));
            deck.add(new Card(i,Suite.HEARTS));
            deck.add(new Card(i,Suite.SPADE));
        }
    }

    public Card dealCard(){
        int rand = (int)(Math.random() * ((deck.size() - 1)));
        Card c = deck.get(rand);
        deck.remove(c);
        delt.add(c);
        return c;
    }
}
