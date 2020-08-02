package org.example.core;

public class Card {
    public String suite;
    public int value;
    public Card(int value, String suite) {
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
}
