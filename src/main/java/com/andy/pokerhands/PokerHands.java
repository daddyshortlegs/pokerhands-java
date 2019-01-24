package com.andy.pokerhands;

import com.andy.pokerhands.rules.RulesEngine;

import java.util.List;

public class PokerHands {

    public String execute(String input) {
        List<Game> games = getAllGames(input);
        return getResultForAllHands(games);
    }

    private List<Game> getAllGames(String input) {
        GameFileReader reader = new GameFileReader();
        return reader.parse(input);
    }

    private String getResultForAllHands(List<Game> games) {
        StringBuilder output = new StringBuilder();
        for (Game game : games) {
            GameResult gameResult = RulesEngine.decideWinner(game.getHand1(), game.getHand2());
            output.append(gameResult.toString()).append("\n");
        }
        return output.toString();
    }

}
