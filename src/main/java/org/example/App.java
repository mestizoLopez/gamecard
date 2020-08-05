package org.example;

import org.example.dao.Game;
import org.example.entity.Player;
import org.example.service.GreatestValueGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<Player> playerList = new ArrayList();

        for (int i = 1; i <= 4; i++) {
            playerList.add(new Player(i));
        }

        try (Game game = GreatestValueGame.getInstance()) {
            for (int i = 0; i < 5; i++) {
                for (Player player : playerList) {
                    game.dealCard(player);
                }
            }

            for (Player player : playerList) {
                Collections.sort(player.getHand());
                player.showHand();
            }
            game.printWinner(playerList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
