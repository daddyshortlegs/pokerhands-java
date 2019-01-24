package com.andy.pokerhands;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CardCounterTest {

    @Test
    public void shouldCountCorrectNumberOfSuit() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardValue.ACE, Suit.HEARTS));
        cards.add(new Card(CardValue.NINE, Suit.CLUBS));
        cards.add(new Card(CardValue.TWO, Suit.HEARTS));
        cards.add(new Card(CardValue.QUEEN, Suit.HEARTS));
        cards.add(new Card(CardValue.ACE, Suit.DIAMONDS));

        CardCounter counter = new CardCounter(cards);

        assertTrue(counter.isSpecificNumberOfSuitInHand(3));
    }

    @Test
    public void shouldCountCorrectNumberOfValues() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardValue.ACE, Suit.HEARTS));
        cards.add(new Card(CardValue.NINE, Suit.CLUBS));
        cards.add(new Card(CardValue.TWO, Suit.HEARTS));
        cards.add(new Card(CardValue.QUEEN, Suit.HEARTS));
        cards.add(new Card(CardValue.ACE, Suit.DIAMONDS));

        CardCounter counter = new CardCounter(cards);

        assertTrue(counter.isSpecificNumberOfValuesInHand(2));
    }


    /*
    Two Pairs: The hand contains 2 different pairs. Hands which both contain 2 pairs are ranked by the value of their
    highest pair. Hands with the same highest pair are ranked by the value of their other pair.
    If these values are the same the hands are ranked by the value of the remaining card.
     */

    @Test
    public void shouldGetHighestAndLowestPair() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardValue.NINE, Suit.HEARTS));
        cards.add(new Card(CardValue.NINE, Suit.CLUBS));
        cards.add(new Card(CardValue.TWO, Suit.HEARTS));
        cards.add(new Card(CardValue.QUEEN, Suit.HEARTS));
        cards.add(new Card(CardValue.QUEEN, Suit.DIAMONDS));

        CardCounter counter = new CardCounter(cards);

        assertEquals(CardValue.QUEEN, counter.getHighestPair());
        assertEquals(CardValue.NINE, counter.getLowestPair());
        assertEquals(CardValue.TWO, counter.getRemainingCard());
    }


}