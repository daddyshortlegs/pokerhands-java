package com.andy.pokerhands.rules;

import com.andy.pokerhands.*;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PairTest {

    // TODO: Something seriously dodgy with this
    @Test
    @Ignore
    public void shouldGetValueOf4Cards() {
        Hand black = HandFactory.create("Black", "2H 2C AD 5S 8H");
        Hand white = HandFactory.create("White", "2H 2C QD 5S 7H");
        Pair pair = new Pair();

        WinResult result = pair.compareTwoHands(black, white);

        assertThat(result.getWinner()).isEqualTo("Black");
        assertThat(result.getWinningItem()).isEqualTo("Ace");
    }
}