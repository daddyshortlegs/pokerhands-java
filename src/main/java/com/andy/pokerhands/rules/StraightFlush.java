package com.andy.pokerhands.rules;

import com.andy.pokerhands.*;

import java.util.List;

public class StraightFlush extends Rule {
    @Override
    public boolean matches(List<Card> hand) {
        if (RulesEngine.consecutiveCards(hand)) {
            CardCounter cardCounter = new CardCounter(hand);
            return cardCounter.isSpecificNumberOfSuitInHand(5);
        }

        return false;
    }

    @Override
    public Ranking getRanking() {
        return Ranking.STRAIGHT_FLUSH;
    }

    @Override
    public WinResult compareTwoHands(Hand hand1, Hand hand2) {
        Card hand1HighestCard = hand1.getHighestCard();
        Card hand2HighestCard = hand2.getHighestCard();
        int i = hand1HighestCard.compareTo(hand2HighestCard);
        Hand winningHand = i > 0 ? hand1 : hand2;

        WinResult winResult = new WinResult();
        winResult.setWinningHand(winningHand.getColour(), getRanking());
        winResult.setWinningItem(winningHand.getHighestCard().getCardValue().toString());
        return winResult;
    }

}
