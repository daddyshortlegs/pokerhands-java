package com.andy.pokerhands.rules;

import com.andy.pokerhands.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TwoPairs extends Rule {
    @Override
    public boolean matches(List<Card> hand) {
        CardCounter cardCounter = new CardCounter(hand);
        Collection<Integer> values = cardCounter.getTheCardValues();
        List<Integer> collect = values.stream().filter(value -> value == 2).collect(Collectors.toList());
        return collect.size() == 2;
    }

    @Override
    public Ranking getRanking() {
        return Ranking.TWO_PAIRS;
    }

    @Override
    public WinResult compareTwoHands(Hand hand1, Hand hand2) {
        CardCounter cardCounter1 = new CardCounter(hand1.getCards());
        CardValue highestPair1 = cardCounter1.getHighestPair();
        CardValue lowestPair1 = cardCounter1.getLowestPair();

        CardCounter cardCounter2 = new CardCounter(hand2.getCards());
        CardValue highestPair2 = cardCounter2.getHighestPair();
        CardValue lowestPair2 = cardCounter2.getLowestPair();

        int i = 0;
        String winningCardValue = "";
        if (highestPair1.compareTo(highestPair2) == 0 && lowestPair1.compareTo(lowestPair2) == 0) {
            CardValue remainingCard1 = cardCounter1.getRemainingCard();
            CardValue remainingCard2 = cardCounter2.getRemainingCard();

            i = remainingCard1.compareTo(remainingCard2);
            winningCardValue = RulesEngine.getWinningValue(remainingCard1, remainingCard2);

        } else if (highestPair1.compareTo(highestPair2) == 0) {
            i = lowestPair1.compareTo(lowestPair2);
            winningCardValue = RulesEngine.getWinningValue(lowestPair1, lowestPair2);
        }

        Hand winningHand = i > 0 ? hand1 : hand2;

        WinResult winResult = new WinResult();
        winResult.setWinningHand(winningHand.getColour(), ((Rule) this).getRanking());
        winResult.setWinningItem(winningCardValue);
        return winResult;
    }

}
