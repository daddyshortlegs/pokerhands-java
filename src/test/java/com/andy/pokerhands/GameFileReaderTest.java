package com.andy.pokerhands;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameFileReaderTest {

    GameFileReader reader = new GameFileReader();

    @Test
    public void shouldCreateSeveralHands() {
        String input = "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH\n" +
                "Black: 2H 4S 4C 2D 4H  White: 2S 8S AS QS 3S\n";

        List<Game> games = reader.parse(input);

        Hand hand1 = games.get(0).getHand1();
        assertThat("Black").isEqualTo(hand1.getColour());
        List<Card> hand1Cards = hand1.getCards();
        assertCard(hand1Cards, 0, CardValue.TWO, Suit.HEARTS);
        assertCard(hand1Cards, 1, CardValue.THREE, Suit.DIAMONDS);
        assertCard(hand1Cards, 2, CardValue.FIVE, Suit.SPADES);
        assertCard(hand1Cards, 3, CardValue.NINE, Suit.CLUBS);
        assertCard(hand1Cards, 4, CardValue.KING, Suit.DIAMONDS);


        Hand hand2 = games.get(0).getHand2();
        assertThat("White").isEqualTo(hand2.getColour());
        List<Card> hand2Cards = hand2.getCards();
        assertCard(hand2Cards, 0, CardValue.TWO, Suit.CLUBS);
        assertCard(hand2Cards, 1, CardValue.THREE, Suit.HEARTS);
        assertCard(hand2Cards, 2, CardValue.FOUR, Suit.SPADES);
        assertCard(hand2Cards, 3, CardValue.EIGHT, Suit.CLUBS);
        assertCard(hand2Cards, 4, CardValue.ACE, Suit.HEARTS);


        Hand hand3 = games.get(1).getHand1();
        assertThat("Black").isEqualTo(hand3.getColour());
        List<Card> hand3Cards = hand3.getCards();
        assertCard(hand3Cards, 0, CardValue.TWO, Suit.HEARTS);
        assertCard(hand3Cards, 1, CardValue.FOUR, Suit.SPADES);
        assertCard(hand3Cards, 2, CardValue.FOUR, Suit.CLUBS);
        assertCard(hand3Cards, 3, CardValue.TWO, Suit.DIAMONDS);
        assertCard(hand3Cards, 4, CardValue.FOUR, Suit.HEARTS);


        Hand hand4 = games.get(1).getHand2();
        assertThat("White").isEqualTo(hand4.getColour());
        List<Card> hand4Cards = hand4.getCards();
        assertCard(hand4Cards, 0, CardValue.TWO, Suit.SPADES);
        assertCard(hand4Cards, 1, CardValue.EIGHT, Suit.SPADES);
        assertCard(hand4Cards, 2, CardValue.ACE, Suit.SPADES);
        assertCard(hand4Cards, 3, CardValue.QUEEN, Suit.SPADES);
        assertCard(hand4Cards, 4, CardValue.THREE, Suit.SPADES);
    }

    private void assertCard(List<Card> hand1Cards, int i, CardValue two, Suit hearts) {
        assertThat(hand1Cards.get(i).getCardValue()).isEqualTo(two);
        assertThat(hand1Cards.get(i).getSuit()).isEqualTo(hearts);
    }
}
