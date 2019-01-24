package com.andy.pokerhands;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Counter<T> {
    private Map<T, Integer> cardCounts = new HashMap<>();

    Collection<Integer> getCounts() {
        return cardCounts.values();
    }

    Set<T> getValues() {
        return cardCounts.keySet();
    }

    Integer getValue(T key) {
        return cardCounts.get(key);
    }

    boolean contains(int number) {
        return getCounts().contains(number);
    }

    void countValues(T value) {
        cardCounts.merge(value, 1, Integer::sum);
    }

}
