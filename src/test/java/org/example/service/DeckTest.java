package org.example.service;

import org.example.exception.EmptyDeckException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;


class DeckTest {

    private Deck deck;

    @Test
    public void ExpectedEmptyDeckExceptionByNullDeck() {
        deck = new Deck();
        deck.setDeck(null);

        Assertions.assertThrows(EmptyDeckException.class, () -> {
            deck.dealCard();
        });

    }

    @Test
    public void ExpectedEmptyDeckExceptionByEmptyDeck() {

        deck = new Deck();
        deck.setDeck(new ArrayList());

        Assertions.assertThrows(EmptyDeckException.class, () -> {
            deck.dealCard();
        });

    }

    @Test
    public void deckIsNotEmpty() throws Exception {
        deck = new Deck();
        deck.dealCard();

        assertTrue(!deck.getDeck().isEmpty());
    }
}