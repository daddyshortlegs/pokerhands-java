package com.andy.pokerhands.rules;

import com.andy.pokerhands.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ThreeOfAKindTest {

    ThreeOfAKind threeOfAKind;

    @Test
    public void shouldGetValueOf3Cards() {
        Hand black = HandFactory.create("Black", "JH 9D JD JS 4D");
        Hand white = HandFactory.create("White", "QH 9D QD QS 4D");
        threeOfAKind = new ThreeOfAKind();

        WinResult result = threeOfAKind.compareTwoHands(white, black);

        assertThat(result.getWinner()).isEqualTo("White");
        assertThat(result.getWinningItem()).isEqualTo("Queen");
    }

//    @Test
//    public void shouldNotBlowUp_WhenRuleIsNotPassedThreeOfAKind() {
//        Hand hand = HandCreatorHelper.createFlush("black");
//        threeOfAKind = new ThreeOfAKind();
//
//        CardValue cardValue = threeOfAKind.getComparable(hand);
//
//        assertThat(cardValue).isEqualTo(CardValue.MINIMUM);
//    }



    /**
     *
     * Straight Flush  : Highest card
     * Four of a kind  : CardValue of 4 cards
     * Full house      : CardValue of 3 cards
     * Flush           : Highest card
     * Straight        : Highest card
     * Three of a kind : CardValue of 3 cards
     * Two pairs       :
     * Pair
     */



}