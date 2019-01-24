package com.andy.pokerhands.rules;

import com.andy.pokerhands.*;

import java.util.List;

public class FullHouse extends Rule {
    @Override
    public boolean matches(List<Card> hand) {
        CardCounter cardCounter = new CardCounter(hand);
        boolean contains3 = cardCounter.isSpecificNumberOfValuesInHand(3);
        boolean contains2 = cardCounter.isSpecificNumberOfValuesInHand(2);
        return contains3 && contains2;
    }

    @Override
    public Ranking getRanking() {
        return Ranking.FULL_HOUSE;
    }

    @Override
    public WinResult compareTwoHands(Hand hand1, Hand hand2) {
        CardCounter cardCounter1 = new CardCounter(hand1.getCards());
        CardValue cardValue = cardCounter1.getCardValueWhereCountIs(3);
        CardValue remainingCard1 = cardCounter1.getHighestPair();


        CardCounter cardCounter2 = new CardCounter(hand2.getCards());
        CardValue cardValue2 = cardCounter2.getCardValueWhereCountIs(3);
        CardValue remainingCard2 = cardCounter2.getHighestPair();


        int i = cardValue.compareTo(cardValue2);
        Hand hand = i > 0 ? hand1 : hand2;
        CardValue winningCardValue = i > 0 ? cardValue : cardValue2;
        CardValue remainingWinningCardValue = i > 0 ? remainingCard1 : remainingCard2;


        WinResult winResult1 = new WinResult();
        winResult1.setWinningHand(hand.getColour(), getRanking());
        winResult1.setWinningItem(winningCardValue.toString() + " over " + remainingWinningCardValue);
        WinResult winResult = winResult1;

        return winResult;
    }


}
