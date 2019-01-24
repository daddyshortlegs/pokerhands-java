package com.andy.pokerhands.rules;

import com.andy.pokerhands.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class StraightFlushTest {

    StraightFlush straightFlush = new StraightFlush();

    @Test
    public void shouldGetTheHighestCard() {
        Hand white = HandFactory.create("White", "2H 3H 4H 5H 6H");
        Hand black = HandFactory.create("Black", "3S 4S 5S 6S 7S");

        WinResult result = straightFlush.compareTwoHands(white, black);

        assertThat(result.getWinner()).isEqualTo("Black");
        assertThat(result.getWinningItem().toString()).isEqualTo("7");
    }

}