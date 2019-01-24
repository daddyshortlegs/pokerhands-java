package com.andy.pokerhands.rules;

import com.andy.pokerhands.*;

import java.util.Collections;
import java.util.List;

import static java.lang.Integer.max;

public class RulesEngine {

    private static Rule[] rules = new Rule[] {
            new StraightFlush(),
            new FourOfAKind(),
            new FullHouse(),
            new Flush(),
            new Straight(),
            new ThreeOfAKind(),
            new TwoPairs(),
            new Pair()
    };

    public static GameResult decideWinner(Hand hand1, Hand hand2) {
        Rule typeOfHand1 = RulesEngine.calculateHandType(hand1.getCards());
        Rule typeOfHand2 = RulesEngine.calculateHandType(hand2.getCards());

        int i = typeOfHand1.getRanking().compareTo(typeOfHand2.getRanking());
        if (i < 0) {
            WinResult gameResult = new WinResult();
            gameResult.setWinningHand(hand2.getColour(), typeOfHand2.getRanking());
            return gameResult;
        } else if (i > 0) {
            WinResult gameResult = new WinResult();
            gameResult.setWinningHand(((Hand) hand1).getColour(), typeOfHand1.getRanking());
            return gameResult;
        }

        return typeOfHand1.compareTwoHands(hand2, hand1);
    }

    public static Rule calculateHandType(List<Card> cards) {
        for (Rule rule : rules) {
            if (rule.matches(cards)) {
                return rule;
            }
        }

        return new HighCard();
    }

    public static boolean consecutiveCards(List<Card> cards) {
        Card min = Collections.min(cards);
        Card max = Collections.max(cards);

        return max.getCardValue().getValue() - min.getCardValue().getValue() == 4;
    }

    public static String getWinningValue(CardValue remainingCard1, CardValue remainingCard2) {
        int winningValue = Integer.max(remainingCard1.getValue(), remainingCard2.getValue());
        return CardValue.valueOf(winningValue).toString();
    }

    public static CardValue getValueOf4Cards(Hand hand) {
        CardCounter cardCounter = new CardCounter(hand.getCards());
        return cardCounter.getCardValueWhereCountIs(4);
    }

    public static int getHighestCard(Card cardsMax1, Card cardsMax2) {
        return max(cardsMax1.getCardValue().getValue() - 1, cardsMax2.getCardValue().getValue() - 1);
    }

    public static CardValue getComparable(Hand hand) {
        CardCounter cardCounter = new CardCounter(hand.getCards());
        return cardCounter.getCardValueWhereCountIs(3);
    }

}
