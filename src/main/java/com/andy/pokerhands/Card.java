package com.andy.pokerhands;

public class Card implements Comparable {
    private final CardValue cardValue;
    private final Suit suit;

    public Card(CardValue cardValue, Suit suit) {
        this.cardValue = cardValue;
        this.suit = suit;
    }

    @Override
    public int compareTo(Object o) {
        Card otherCard = (Card)o;
        return getCardValue().compareTo(otherCard.getCardValue());
    }

    public CardValue getCardValue() {
        return cardValue;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return cardValue.toString() + " " + suit.toString();
    }
}
