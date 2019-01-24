package com.andy.pokerhands;

public enum Ranking {
    HIGH_CARD, PAIR, TWO_PAIRS, THREE_OF_A_KIND, STRAIGHT, FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH;

    @Override
    public String toString() {
        return name().replace("_", " ").toLowerCase();
    }
}
