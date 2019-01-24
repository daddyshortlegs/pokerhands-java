package com.andy.pokerhands.rules;

import com.andy.pokerhands.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HighCard extends Rule {
    @Override
    public boolean matches(List<Card> hand) {
        return true;
    }

    @Override
    public Ranking getRanking() {
        return Ranking.HIGH_CARD;
    }

    @Override
    public GameResult compareTwoHands(Hand hand1, Hand hand2) {
        List<Card> reducedHand1 = hand1.getCards();
        List<Card> reducedHand2 = hand2.getCards();

        int result = 0;
        CardValue winningCardValue = null;
        boolean cardsAreEqual = true;
        do  {
            Card cardsMax1 = Collections.max(reducedHand1);
            Card cardsMax2 = Collections.max(reducedHand2);

            if (cardsMax1.getCardValue() == cardsMax2.getCardValue()) {
                reducedHand1 = reducedHand1.stream().filter(card -> card != cardsMax1).collect(Collectors.toList());
                reducedHand2 = reducedHand2.stream().filter(card -> card != cardsMax2).collect(Collectors.toList());

                if (reducedHand1.size() == 0) {
                    return new TieResult();
                }
            } else {
                result = cardsMax1.compareTo(cardsMax2);
                if (result != 0) {
                    CardValue[] values = CardValue.values();
                    winningCardValue = values[RulesEngine.getHighestCard(cardsMax1, cardsMax2)];
                    break;
                }
                cardsAreEqual = false;
            }

        } while (cardsAreEqual);

        WinResult winResult = new WinResult();
        Hand hand = result > 0 ? hand1 : hand2;
        winResult.setWinningHand(hand.getColour(), getRanking());
        winResult.setWinningItem(winningCardValue.toString());
        return winResult;
    }


}
