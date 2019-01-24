package com.andy.pokerhands;

import com.andy.pokerhands.rules.Rule;
import com.andy.pokerhands.rules.RulesEngine;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    @Test
    public void shouldShowWinnerWithType() {
        Hand white = HandCreatorHelper.createHighCard("White");
        Rule rule = RulesEngine.calculateHandType(white.getCards());

        WinResult gameResult = new WinResult();
        gameResult.setWinningHand(white.getColour(), rule.getRanking());
        gameResult.setWinningItem("King");

        assertThat(gameResult.toString()).isEqualTo("White wins. - with high card: King");
    }

    @Test
    public void shouldShowOtherWinnerWithType() {
        Hand black = HandCreatorHelper.createFullHouse("Black");
        Rule rule = RulesEngine.calculateHandType(black.getCards());

        WinResult gameResult = new WinResult();
        gameResult.setWinningHand(black.getColour(), rule.getRanking());
        gameResult.setWinningItem("5");

        assertThat(gameResult.toString()).isEqualTo("Black wins. - with full house: 5");
    }

    @Test
    public void shouldNotShowCard() {
        Hand black = HandCreatorHelper.createFullHouse("Black");
        Rule rule = RulesEngine.calculateHandType(black.getCards());

        WinResult gameResult = new WinResult();
        gameResult.setWinningHand(black.getColour(), rule.getRanking());

        assertThat(gameResult.toString()).isEqualTo("Black wins. - with full house");
    }

}