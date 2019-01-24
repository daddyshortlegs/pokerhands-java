package com.andy.pokerhands;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardParserTest {

    CardParser cardParser = new CardParser();

    @Test
    public void shouldCreateTheCorrectCards() {
        assertCardIs(cardParser.create("9S"), CardValue.NINE, Suit.SPADES);
        assertCardIs(cardParser.create("9D"), CardValue.NINE, Suit.DIAMONDS);
        assertCardIs(cardParser.create("9H"), CardValue.NINE, Suit.HEARTS);
        assertCardIs(cardParser.create("9C"), CardValue.NINE, Suit.CLUBS);
        assertCardIs(cardParser.create("TH"), CardValue.TEN, Suit.HEARTS);
        assertCardIs(cardParser.create("AC"), CardValue.ACE, Suit.CLUBS);
        assertCardIs(cardParser.create("JH"), CardValue.JACK, Suit.HEARTS);
        assertCardIs(cardParser.create("QD"), CardValue.QUEEN, Suit.DIAMONDS);
        assertCardIs(cardParser.create("KS"), CardValue.KING, Suit.SPADES);
    }

    private void assertCardIs(Card card, CardValue ace, Suit spades) {
        assertThat(card.getCardValue()).isEqualTo(ace);
        assertThat(card.getSuit()).isEqualTo(spades);
    }

}