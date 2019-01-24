package com.andy.pokerhands.rules;

import com.andy.pokerhands.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StraightTest {

    Straight straight;

    @Test
    public void shouldGetValueOf4Cards() {
        Hand black = HandFactory.create("Black", "2H 3C 4D 5S 6H");
        Hand white = HandFactory.create("White", "3H 4C 5D 6S 7H");
        straight = new Straight();

        WinResult result = straight.compareTwoHands(black, white);

        assertThat(result.getWinner()).isEqualTo("White");
        assertThat(result.getWinningItem().toString()).isEqualTo("7");
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