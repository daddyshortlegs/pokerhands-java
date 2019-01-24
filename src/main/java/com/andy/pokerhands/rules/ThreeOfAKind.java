package com.andy.pokerhands.rules;

import com.andy.pokerhands.*;

import java.util.List;

public class ThreeOfAKind extends Rule {
    @Override
    public boolean matches(List<Card> hand) {
        CardCounter cardCounter = new CardCounter(hand);
        return cardCounter.isSpecificNumberOfValuesInHand(3);
    }

    @Override
    public Ranking getRanking() {
        return Ranking.THREE_OF_A_KIND;
    }

    @Override
    public WinResult compareTwoHands(Hand hand1, Hand hand2) {
        CardValue cardValue = RulesEngine.getComparable(hand1);
        CardValue cardValue2 = RulesEngine.getComparable(hand2);

        int i = cardValue.compareTo(cardValue2);
        Hand hand = i > 0 ? hand1 : hand2;

        WinResult winResult1 = new WinResult();
        winResult1.setWinningHand(hand.getColour(), getRanking());

        CardValue winningCardValue = i > 0 ? cardValue : cardValue2;
        winResult1.setWinningItem(winningCardValue.toString());
        WinResult winResult = winResult1;

        return winResult;
    }


}
