package com.andy.pokerhands.rules;

import com.andy.pokerhands.*;

import java.util.*;

public abstract class Rule {

    public abstract boolean matches(List<Card> hand);

    public abstract GameResult compareTwoHands(Hand hand1, Hand hand2);

    public abstract Ranking getRanking();

    @Override
    public String toString() {
        return getRanking().toString();
    }


}
