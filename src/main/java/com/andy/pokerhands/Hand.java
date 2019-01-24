package com.andy.pokerhands;

import java.util.Collections;
import java.util.List;

public class Hand {
    private final List<Card> cards;
    private final String colour;

    public Hand(String colour, List<Card> cards) {
        this.colour = colour;
        this.cards = cards;
    }

    public String getColour() {
        return colour;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Card getHighestCard() {
        return Collections.max(cards);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (Card card : cards) {
            out.append(card).append(" ");
        }
        return out.toString();
    }
}
