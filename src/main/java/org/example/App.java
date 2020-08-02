package org.example;

import org.example.core.Game;
import org.example.core.Player;

public class App {
    public static void main(String[] args) {
        Player p1 = new Player();
        Player p2 = new Player();
        Game game = Game.getInstance();
        for (int i= 0; i < 5; i++) {
            game.dealCard(p1);
            game.dealCard(p2);
        }
        p1.showHand();
        p2.showHand();
        game.printWinner(p1, p2);
    }
}
