package com.andy.pokerhands;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GameFileReader {

    private static Pattern LINE_PATTERN = Pattern.compile("^(Black): (.*?) (White): (.*?)$");

    List<Game> parse(String input) {
        List<Game> games = new ArrayList<>();
        for (String line : splitInputByNewLine(input)) {
            readLine(games, line);
        }

        return games;
    }

    private String[] splitInputByNewLine(String input) {
        return input.split("\n");
    }

    private void readLine(List<Game> games, String line) {
        Matcher matcher = LINE_PATTERN.matcher(line);
        if (matcher.matches()) {
            Hand hand1 = getHand(matcher, 1, 2);
            Hand hand2 = getHand(matcher, 3, 4);
            games.add(new Game(hand1, hand2));
        }
    }

    private Hand getHand(Matcher matcher, int playerGroup, int cardGroup) {
        return HandFactory.create(matcher.group(playerGroup), matcher.group(cardGroup));
    }
}
