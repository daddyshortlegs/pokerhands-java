package com.andy.pokerhands;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class CardTest {

    @Test
    public void shouldBeTrueWhenThisVardIsLower() {
        Card card1 = new Card(CardValue.FOUR, Suit.HEARTS);
        Card card2 = new Card(CardValue.JACK, Suit.DIAMONDS);

        int i = card1.compareTo(card2);

        assertThat(i).isLessThan(0);
    }

    @Test
    public void shouldBeTrueWhenEqual() {
        Card card1 = new Card(CardValue.JACK, Suit.HEARTS);
        Card card2 = new Card(CardValue.JACK, Suit.DIAMONDS);

        int i = card1.compareTo(card2);

        assertThat(i).isEqualTo(0);
    }

    @Test
    public void shouldBeTrueWhenThisCardIshigher() {
        Card card1 = new Card(CardValue.JACK, Suit.HEARTS);
        Card card2 = new Card(CardValue.TWO, Suit.DIAMONDS);

        int i = card1.compareTo(card2);

        assertThat(i).isGreaterThan(0);
    }

}
