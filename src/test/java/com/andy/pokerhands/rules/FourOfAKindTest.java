package com.andy.pokerhands.rules;

import com.andy.pokerhands.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FourOfAKindTest {

    FourOfAKind fourOfAKind;

    @Test
    public void shouldGetValueOf4Cards() {
        Hand white = HandFactory.create("White", "4H 4S 4D 5H 4C");
        Hand black = HandFactory.create("Black", "5H 5S 5D 6H 5C");
        fourOfAKind = new FourOfAKind();

        WinResult result = fourOfAKind.compareTwoHands(white, black);

        assertThat(result.getWinner()).isEqualTo("Black");
        assertThat(result.getWinningItem()).isEqualTo("5");
    }

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