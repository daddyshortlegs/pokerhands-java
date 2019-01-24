package com.andy.pokerhands;

import java.util.ArrayList;
import java.util.List;

public class HandFactory {

    private HandFactory() {}

    public static Hand create(String colour, String line) {
        List<Card> asList = getCards(splitLineIntoSeparateCards(line));
        return new Hand(colour, asList);
    }

    private static String[] splitLineIntoSeparateCards(String handLine) {
        return handLine.split(" ");
    }

    private static List<Card> getCards(String[] codes) {
        List<Card> asList = new ArrayList<>();
        for (String code : codes) {
            asList.add(CardParser.create(code));
        }
        return asList;
    }


}
