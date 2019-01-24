package com.andy.pokerhands;

class Game {
    private final Hand hand1;
    private final Hand hand2;

    Game(Hand hand1, Hand hand2) {
        this.hand1 = hand1;
        this.hand2 = hand2;
    }

    public Hand getHand1() {
        return hand1;
    }

    public Hand getHand2() {
        return hand2;
    }
}
