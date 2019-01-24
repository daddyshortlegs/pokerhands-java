package com.andy.pokerhands;

import com.andy.pokerhands.rules.RulesEngine;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class PokerHandsTest {
    private PokerHands pokerHands;

    @Before
    public void setup() {
        pokerHands = new PokerHands();
    }

    @Test
    public void shouldRateFullHouseHigherThanAFlush() {
        Hand black = HandCreatorHelper.createFlush("Black");
        Hand white = HandCreatorHelper.createFullHouse("White");

        GameResult gameResult = RulesEngine.decideWinner(black, white);

        assertThat(gameResult.toString()).isEqualTo("White wins. - with full house");
    }


    @Test
    public void shouldRateStraightFLushHigherThanAPair() {
        Hand black = HandCreatorHelper.createStraightFlush("Black");
        Hand white = HandCreatorHelper.createPair("White");

        GameResult gameResult = RulesEngine.decideWinner(black, white);

        assertThat(gameResult.toString()).isEqualTo("Black wins. - with straight flush");
    }

    @Test
    public void shouldRateTwoPairsHigherThanAPair() {
        Hand black = HandCreatorHelper.createTwoPairs("Black");
        Hand white = HandCreatorHelper.createPair("White");

        GameResult gameResult = RulesEngine.decideWinner(black, white);

        assertThat(gameResult.toString()).isEqualTo("Black wins. - with two pairs");
    }

    @Test
    public void straightFlushBeatsFourOfAKind() {
        // Given
        Hand straightFlush = HandFactory.create("Black", "2H 3H 4H 5H 6H");
        Hand fourOfAKind = HandFactory.create("White", "4H 4S 4D 5H 4C");

        // When
        GameResult winningHand = RulesEngine.decideWinner(straightFlush, fourOfAKind);

        // Then
        assertThat(winningHand.toString()).isEqualTo("Black wins. - with straight flush");
    }

    @Test
    public void twoStraightFlushes() {
        Hand hand1 = HandFactory.create("Black", "2H 3H 4H 5H 6H");
        Hand hand2 = HandFactory.create("White", "3H 4H 5H 6H 7H");

        GameResult gameResult = RulesEngine.decideWinner(hand2, hand1);

        assertThat(gameResult.toString()).isEqualTo("White wins. - with straight flush: 7");
    }

    @Test
    public void twoFourOfAKinds() {
        Hand hand1 = HandFactory.create("Black", "5H 5S 5D 3H 5C");
        Hand hand2 = HandFactory.create("White", "4H 4S 4D 6H 4C");

        GameResult gameResult = RulesEngine.decideWinner(hand1, hand2);

        assertThat(gameResult.toString()).isEqualTo("Black wins. - with four of a kind: 5");
    }

    @Test
    public void twoFullHouse() {
        Hand hand1 = HandFactory.create("Black", "2H 5S 5C 2D 5H");
        Hand hand2 = HandFactory.create("White", "4H 4S 4D 5H 5C");

        GameResult gameResult = RulesEngine.decideWinner(hand1, hand2);

        assertThat(gameResult.toString()).isEqualTo("Black wins. - with full house: 5 over 2");
    }

    @Test
    public void twoFlushes() {
        Hand hand1 = HandFactory.create("Black", "2D 3D AD 6D 5D");
        Hand hand2 = HandFactory.create("White", "2S 9S JS KS 4S");

        GameResult gameResult = RulesEngine.decideWinner(hand1, hand2);

        assertThat(gameResult.toString()).isEqualTo("Black wins. - with flush: Ace");
    }

    @Test
    public void twoStraights() {
        Hand hand1 = HandFactory.create("Black", "2H 3C 4D 5S 6H");
        Hand hand2 = HandFactory.create("White", "3C 4D 5S 6H 7H");

        GameResult gameResult = RulesEngine.decideWinner(hand1, hand2);

        assertThat(gameResult.toString()).isEqualTo("White wins. - with straight: 7");
    }

    // TODO: May need some more examples around 3 of a kinds
    @Test
    public void twoThreeOfAKinds() {
        Hand hand1 = HandFactory.create("Black", "5H 5S 5D 2H 4C");
        Hand hand2 = HandFactory.create("White", "3H 3S AD 7H 3C");

        GameResult gameResult = RulesEngine.decideWinner(hand1, hand2);

        assertThat(gameResult.toString()).isEqualTo("Black wins. - with three of a kind: 5");
    }

    @Test
    public void twoHighCards() {
        Hand hand1 = HandFactory.create("White", "2H 9D JD KS 4D");
        Hand hand2 = HandFactory.create("Black", "2H 9D JD QS 4D");

        GameResult gameResult = RulesEngine.decideWinner(hand1, hand2);

        assertThat(gameResult.toString()).isEqualTo("White wins. - with high card: King");
    }

    @Test
    public void twoHighCards2() {
        Hand hand1 = HandFactory.create("Black", "2H 3D 5S 9C KD");
        Hand hand2 = HandFactory.create("White", "2C 3H 4S 8C AH");

        GameResult gameResult = RulesEngine.decideWinner(hand1, hand2);

        assertThat(gameResult.toString()).isEqualTo("White wins. - with high card: Ace");
    }


    // Black: 2H 3D 5S 9C KD  White: 2D 3H 5C 9S KH\
    @Test
    public void tie() {
        Hand hand1 = HandFactory.create("Black", "2H 3D 5S 9C KD");
        Hand hand2 = HandFactory.create("White", "2D 3H 5C 9S KH");

        GameResult gameResult = RulesEngine.decideWinner(hand1, hand2);

        assertThat(gameResult instanceof TieResult).isEqualTo(true);
    }


    @Test
    public void shouldGetHighestCard() {
        Hand hand1 = HandFactory.create("White", "2H 9D JD KS 4D");
        Hand hand2 = HandFactory.create("Black", "2H 9D JD QS 4D");

        GameResult gameResult = RulesEngine.decideWinner(hand1, hand2);

        assertThat(gameResult.toString()).isEqualTo("White wins. - with high card: King");
    }

    @Test
    public void shouldGetSecondHighestCard_WhenHighestCardsInHandsAreTheSame() {
        Hand hand1 = HandFactory.create("White", "2H 9D JD KS 4D");
        Hand hand2 = HandFactory.create("Black", "2H 9D QD KS 4D");

        GameResult gameResult = RulesEngine.decideWinner(hand1, hand2);

        assertThat(gameResult.toString()).isEqualTo("Black wins. - with high card: Queen");
    }

    @Test
    public void shouldGetThirdHighestCard_WhenHighestCardsInHandsAreTheSame() {
        Hand hand1 = HandFactory.create("White", "2H 9D QD KS 4D");
        Hand hand2 = HandFactory.create("Black", "2H 8D QD KS 4D");

        GameResult gameResult = RulesEngine.decideWinner(hand1, hand2);

        assertThat(gameResult.toString()).isEqualTo("White wins. - with high card: 9");
    }



        /*
    Two Pairs: The hand contains 2 different pairs. Hands which both contain 2 pairs are ranked by the value of their
    highest pair. Hands with the same highest pair are ranked by the value of their other pair.
    If these values are the same the hands are ranked by the value of the remaining card.
     */

    @Test
    public void shouldRankLowestTwoPairsWhenHighestPairsAreTheSame() {
        Hand hand1 = HandFactory.create("White", "2H 2D JD JS 4D");
        Hand hand2 = HandFactory.create("Black", "3H 3D JD JS 4D");

        GameResult gameResult = RulesEngine.decideWinner(hand1, hand2);

        assertThat(gameResult.toString()).isEqualTo("Black wins. - with two pairs: 3");
    }

    @Test
    public void shouldRankLowestTwoPairsWhenHighestPairsAreTheSame2() {
        Hand hand1 = HandFactory.create("White", "KH KD AD AS 4D");
        Hand hand2 = HandFactory.create("Black", "QH QD AD AS 4D");

        GameResult gameResult = RulesEngine.decideWinner(hand1, hand2);

        assertThat(gameResult.toString()).isEqualTo("White wins. - with two pairs: King");
    }

    @Test
    public void shouldRankRemainingCards_WhenBothPairsAreTheSame() {
        Hand hand1 = HandFactory.create("White", "KH KD AC AH 4S");
        Hand hand2 = HandFactory.create("Black", "KC KS AD AS 5D");

        GameResult gameResult = RulesEngine.decideWinner(hand1, hand2);

        assertThat(gameResult.toString()).isEqualTo("Black wins. - with two pairs: 5");
    }



    /* Pair.
    2 of the 5 cards in the hand have the same value. Hands which both contain a pair are ranked by the value of the
    cards forming the pair. If these values are the same, the hands are ranked by the values of the cards not forming
    the pair, in decreasing order.

     */

}
