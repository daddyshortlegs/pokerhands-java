package com.andy.pokerhands.rules;

import com.andy.pokerhands.GameResult;
import com.andy.pokerhands.Hand;
import com.andy.pokerhands.HandFactory;
import com.andy.pokerhands.WinResult;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HighCardTest {

    @Test
    public void shouldGetHighCard() {
        HighCard highCard = new HighCard();

        Hand black = HandFactory.create("Black", "2H 3C AD 5S 8H");
        Hand white = HandFactory.create("White", "2H 4C QD 5S 7H");

        WinResult result = (WinResult) highCard.compareTwoHands(black, white);

        assertThat(result.getWinner()).isEqualTo("Black");
        assertThat(result.getWinningItem()).isEqualTo("Ace");

    }
}