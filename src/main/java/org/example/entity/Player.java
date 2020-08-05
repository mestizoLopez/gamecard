package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> hand;
    private int number;

    public Player(int number) {
        this.number = number;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
