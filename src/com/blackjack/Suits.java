package com.blackjack;

public enum Suits {
    DIAMOND("Diamonds"), HEART("Hearts"), SPADE("Spades"), CLUB("Clubs");
    final String suitName;

    Suits(String suitName) {
        this.suitName = suitName;
    }
    public String toString(){
        return suitName;
    }
}
