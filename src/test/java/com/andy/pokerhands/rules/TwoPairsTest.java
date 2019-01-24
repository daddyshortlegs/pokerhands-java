package com.andy.pokerhands.rules;

import com.andy.pokerhands.Hand;
import com.andy.pokerhands.HandFactory;
import com.andy.pokerhands.WinResult;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoPairsTest {

    private TwoPairs twoPairs;

    @Test
    public void shouldRankLowestPair() {
        Hand white = HandFactory.create("White", "2H 2D JD JS 4D");
        Hand black = HandFactory.create("Black", "3H 3D JD JS 4D");
        twoPairs = new TwoPairs();

        WinResult result = twoPairs.compareTwoHands(black, white);

        assertThat(result.getWinner()).isEqualTo("Black");
        assertThat(result.getWinningItem()).isEqualTo("3");
    }

    @Test
    public void shouldRankRemainingCard_WhenPairsTheSame() {
        Hand black = HandFactory.create("Black", "2H 2C 5D 5S 6H");
        Hand white = HandFactory.create("White", "2H 2C 5D 5S 7H");
        twoPairs = new TwoPairs();

        WinResult result = twoPairs.compareTwoHands(black, white);

        assertThat(result.getWinner()).isEqualTo("White");
        assertThat(result.getWinningItem()).isEqualTo("7");
    }

}