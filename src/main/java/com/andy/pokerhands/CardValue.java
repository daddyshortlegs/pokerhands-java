package com.andy.pokerhands;

import java.util.HashMap;
import java.util.Map;

public enum CardValue {
    MINIMUM("", 0),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JACK("Jack", 11),
    QUEEN("Queen", 12),
    KING("King", 13),
    ACE("Ace", 14);

    private final String name;
    private final int value;

    private static final Map<Integer, CardValue> map = new HashMap<>();

    static {
        for (CardValue cardValue : CardValue.values()) {
            map.put(cardValue.value, cardValue);
        }
    }

    public static CardValue valueOf(int cardValue) {
        return map.get(cardValue);
    }

    CardValue(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getValue() {
        return value;
    }

}
