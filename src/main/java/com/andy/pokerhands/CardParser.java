package com.andy.pokerhands;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CardParser {
    private static Pattern CARD_PATTERN = Pattern.compile("^([2-9TJQKA])([HDCS])$");

    static Card create(String code) {
        Matcher matcher = CARD_PATTERN.matcher(code);
        if (matcher.matches()) {
            String value = matcher.group(1);
            String suit = matcher.group(2);
            return new Card(cardValues().get(value), cardSuits().get(suit));

        }
        return null;
    }

    private static Map<String, CardValue> cardValues() {
        Map<String, CardValue> values = new HashMap<>();
        values.put("2", CardValue.TWO);
        values.put("3", CardValue.THREE);
        values.put("4", CardValue.FOUR);
        values.put("5", CardValue.FIVE);
        values.put("6", CardValue.SIX);
        values.put("7", CardValue.SEVEN);
        values.put("8", CardValue.EIGHT);
        values.put("9", CardValue.NINE);
        values.put("T", CardValue.TEN);
        values.put("J", CardValue.JACK);
        values.put("Q", CardValue.QUEEN);
        values.put("K", CardValue.KING);
        values.put("A", CardValue.ACE);
        return values;
    }

    private static Map<String, Suit> cardSuits() {
        Map<String, Suit> suits = new HashMap<>();
        suits.put("H", Suit.HEARTS);
        suits.put("S", Suit.SPADES);
        suits.put("D", Suit.DIAMONDS);
        suits.put("C", Suit.CLUBS);
        return suits;
    }
}
