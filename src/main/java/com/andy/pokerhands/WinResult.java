package com.andy.pokerhands;

public class WinResult implements GameResult {

    private String colour;
    private Ranking ranking;
    private String winningItem;

    @Override
    public String toString() {
        String winningCard = winningItem != null ? ": " + winningItem : "";
        return getWinner() + " wins. - with " + ranking + winningCard;
    }

    public String getWinner() {
        return colour;
    }

    public void setWinningHand(String colour, Ranking ranking) {
        this.colour = colour;
        this.ranking = ranking;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public String getWinningItem() {
        return winningItem;
    }

    public void setWinningItem(String winningItem) {
        this.winningItem = winningItem;
    }
}
