package com.andy.pokerhands.rules;

import com.andy.pokerhands.Hand;
import com.andy.pokerhands.HandFactory;
import com.andy.pokerhands.WinResult;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FlushTest {

    Flush flush = new Flush();

    @Test
    public void shouldGetTheHighestCard() {
        Hand white = HandFactory.create("White", "2D 9D JD KD 4D");
        Hand black = HandFactory.create("Black", "2S 9S JS AS 4S");

        WinResult result = flush.compareTwoHands(white, black);

        assertThat(result.getWinner()).isEqualTo("Black");
        assertThat(result.getWinningItem().toString()).isEqualTo("Ace");
    }
}