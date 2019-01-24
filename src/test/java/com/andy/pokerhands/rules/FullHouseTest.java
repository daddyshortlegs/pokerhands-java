package com.andy.pokerhands.rules;

import com.andy.pokerhands.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FullHouseTest {

    FullHouse fullHouse;

    @Test
    public void shouldGetValueOf3Cards() {
        Hand white = HandFactory.create("White", "2H 5S 5C 2D 5H");
        Hand black = HandFactory.create("Black", "2H 4S 4C 2D 4H");
        fullHouse = new FullHouse();

        WinResult result = fullHouse.compareTwoHands(white, black);

        assertThat(result.getWinner()).isEqualTo("White");
        assertThat(result.getWinningItem()).isEqualTo("5 over 2");
    }
}