package com.andy.pokerhands;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HandTest {

    Hand hand;

    //Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH
    @Test
    public void shouldReportHighestCardInHand() {
        Card card5 = new Card(CardValue.KING, Suit.DIAMONDS);

        hand = HandFactory.create("White", "2H 3D 5S 9C KD");

        Card highest = hand.getHighestCard();

        assertThat(highest.toString()).isEqualTo(card5.toString());
    }

}
