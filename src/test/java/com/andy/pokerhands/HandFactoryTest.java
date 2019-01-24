package com.andy.pokerhands;

import com.andy.pokerhands.rules.Rule;
import com.andy.pokerhands.rules.RulesEngine;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HandFactoryTest {

    @Test
    public void straightFlush() {
        Hand black = HandCreatorHelper.createStraightFlush("Black");
        Ranking ranking = getRanking(black);
        assertThat(ranking).isEqualTo(Ranking.STRAIGHT_FLUSH);
    }

    // Four of a kind: 4 cards with the same value. Ranked by the value of the 4 cards.
    @Test
    public void fourOfAKind() {
        Hand black = HandCreatorHelper.createFourOfAKind("Black");
        Ranking ranking = getRanking(black);
        assertThat(ranking).isEqualTo(Ranking.FOUR_OF_A_KIND);
    }

    // Full House: 3 cards of the same value, with the remaining 2 cards forming a pair. Ranked by the value of the 3 cards
    @Test
    public void fullHouse() {
        Hand black = HandCreatorHelper.createFullHouse("Black");
        Ranking ranking = getRanking(black);
        assertThat(ranking).isEqualTo(Ranking.FULL_HOUSE);
    }

    // Flush: Hand contains 5 cards of the same suit. Hands which are both flushes are ranked using the rules for High Card.
    @Test
    public void flush() {
        Hand black = HandCreatorHelper.createFlush("Black");
        Ranking ranking = getRanking(black);
        assertThat(ranking).isEqualTo(Ranking.FLUSH);
    }

    // Straight: Hand contains 5 cards with consecutive values
    @Test
    public void straight() {
        Hand black = HandCreatorHelper.createStraight("Black");
        Ranking ranking = getRanking(black);
        assertThat(ranking).isEqualTo(Ranking.STRAIGHT);
    }

    // Three of a Kind: Three of the cards in the hand have the same value. Hands which both contain three of a kind are ranked by the value of the 3 cards.
    @Test
    public void threeOfAKind() {
        Hand black = HandCreatorHelper.createThreeOfAKind("Black");
        Ranking ranking = getRanking(black);
        assertThat(ranking).isEqualTo(Ranking.THREE_OF_A_KIND);
    }

    // Pair: 2 of the 5 cards in the hand have the same value
    @Test
    public void pair() {
        Hand black = HandCreatorHelper.createPair("Black");
        Ranking ranking = getRanking(black);
        assertThat(ranking).isEqualTo(Ranking.PAIR);
    }

    @Test
    public void twoPairs() {
        Hand black = HandCreatorHelper.createTwoPairs("Black");
        Ranking ranking = getRanking(black);
        assertThat(ranking).isEqualTo(Ranking.TWO_PAIRS);
    }

    @Test
    public void highCard() {
        Hand black = HandFactory.create("Black", "2H 9D JD QS 4D");
        Ranking ranking = getRanking(black);
        assertThat(ranking).isEqualTo(Ranking.HIGH_CARD);
    }

    private Ranking getRanking(Hand black) {
        Rule rule = RulesEngine.calculateHandType(black.getCards());
        return rule.getRanking();
    }

}