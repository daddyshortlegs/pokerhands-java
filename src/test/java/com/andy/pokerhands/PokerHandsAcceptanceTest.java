package com.andy.pokerhands;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PokerHandsAcceptanceTest {

    PokerHands pokerHands = new PokerHands();

    @Test
    @Ignore
    public void shouldReadInFileAndProduceOutput() {
        String input = "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH\n" +
                "Black: 2H 4S 4C 2D 4H  White: 2S 8S AS QS 3S\n" +
                "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C KH\n" +
                "Black: 2H 3D 5S 9C KD  White: 2D 3H 5C 9S KH\n";

        String expectedOutput = "White wins. - with high card: Ace\n" +
                "Black wins. - with full house: 4 over 2\n" +
                "Black wins. - with high card: 9\n" +
                "Tie.\n";

        String actual = pokerHands.execute(input);
        assertThat(actual).isEqualTo(expectedOutput);
    }

}