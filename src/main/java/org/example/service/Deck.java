package org.example.service;

import org.example.consts.Suite;
import org.example.entity.Card;
import org.example.exception.EmptyDeckException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Deck {

    private List<Card> deck;

    public Deck() {
        deck = new ArrayList();
        /*
        for(int i = 1 ; i <= 13 ; i++){
            deck.add(new Card(i, Suite.CLUBS));
            deck.add(new Card(i,Suite.DIAMONDS));
            deck.add(new Card(i,Suite.HEARTS));
            deck.add(new Card(i,Suite.SPADE));
        }
         */
    }

    public Card dealCard() throws Exception {

        Optional.ofNullable(deck).orElseThrow( ()-> new EmptyDeckException("null there aren't cards in the deck"));
        if(!deck.isEmpty()) {
            final int rand = (int) (Math.random() * ((deck.size() - 1)));
            final Card card = deck.get(rand);
            deck.remove(card);
            return card;
        }else{
            throw new EmptyDeckException("There isn't more card in the deck");
        }

    }

    public List<Card> getDeck() {
        return deck;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }
}
