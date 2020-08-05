package org.example.dao;

import org.example.entity.Player;

import java.util.List;

public interface Game extends AutoCloseable {

    public void printWinner(List<Player> playerList) throws Exception;

    public void dealCard(Player player) throws Exception;

}
