package com.andy.pokerhands;

public class HandCreatorHelper {

    public static Hand createStraightFlush(String colour) {
        return HandFactory.create(colour, "2H 3H 4H 5H 6H");
    }

    public static Hand createFourOfAKind(String colour) {
        return HandFactory.create(colour, "4H 4S 4D 5H 4C");
    }

    public static Hand createFullHouse(String colour) {
        return HandFactory.create(colour, "2H 4S 4C 2D 4H");
    }

    public static Hand createFlush(String colour) { return HandFactory.create(colour, "2D 9D JD AD 4D"); }

    public static Hand createStraight(String colour) { return HandFactory.create(colour, "2H 3C 4D 5S 6H"); }

    public static Hand createThreeOfAKind(String colour) {
        return HandFactory.create(colour, "JH 9D JD JS 4D");
    }

    public static Hand createTwoPairs(String colour) { return HandFactory.create(colour, "4H 9D JD JS 4D"); }

    public static Hand createPair(String colour) { return HandFactory.create(colour, "3H 9D TD TS 4D"); }

    public static Hand createHighCard(String colour) { return HandFactory.create(colour, "3H 9D JD QS 4D"); }

}
