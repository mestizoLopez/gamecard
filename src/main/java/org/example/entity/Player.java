package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private  List<Card> hand;

    public Player() {
        hand = new ArrayList();
    }

    public void showHand() {
        System.out.println(hand);
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }
}
