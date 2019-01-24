package com.andy.pokerhands;

import java.util.*;
import java.util.stream.Collectors;

public class CardCounter {

    Counter<CardValue> valueCounter = new Counter<>();
    Counter<Suit> suitCounter = new Counter<>();

    public CardCounter(List<Card> cards) {
        for (Card card : cards) {
            valueCounter.countValues(card.getCardValue());
            suitCounter.countValues(card.getSuit());
        }
    }

    public boolean isSpecificNumberOfSuitInHand(int numberOfSuit) {
        return suitCounter.contains(numberOfSuit);
    }

    public boolean isSpecificNumberOfValuesInHand(int numberOfValues) {
        return valueCounter.contains(numberOfValues);
    }

    public Collection<Integer> getTheCardValues() {
        return valueCounter.getCounts();
    }

    public CardValue getCardValueWhereCountIs(int count) {
        List<CardValue> cardValues = getCardValuesByTheirOccurrence(count);
        if (cardValues.size() == 0) {
            return CardValue.MINIMUM;
        }
        return cardValues.get(0);
    }

    public CardValue getHighestPair() {
        return Collections.max(getCardValuesByTheirOccurrence(2));
    }

    public CardValue getLowestPair() {
        return Collections.min(getCardValuesByTheirOccurrence(2));
    }

    public CardValue getRemainingCard() {
        List<CardValue> cardValues = getCardValuesByTheirOccurrence(1);
        if (cardValues.size() == 0) {
            return null;
        }

        return cardValues.get(0);
    }

    private List<CardValue> getCardValuesByTheirOccurrence(int cardCount) {
        return valueCounter.getValues().stream()
                .filter(value -> valueCounter.getValue(value) == cardCount)
                .collect(Collectors.toList());
    }
}
