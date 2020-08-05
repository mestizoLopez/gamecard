package org.example.entity;

import org.example.consts.Suite;

public class Card implements Comparable<Card> {

    private Suite suite;
    private int value;

    public Card(int value, Suite suite) {
        this.suite = suite;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suite='" + suite + '\'' +
                ", value=" + value +
                '}';
    }

    public Suite getSuite() {
        return suite;
    }

    public void setSuite(Suite suite) {
        this.suite = suite;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Card card) {
        return card.value - this.value;
    }
}
