package com.blackjack;

import java.util.Random;

public class Card {

    private final Suits suit;
    private final Values value;

    //constructors
    public Card(Suits suit, Values value) {
        this.suit = suit;
        this.value = value;
    }
    public Card(Card card) {
        this.suit = card.getSuit();
        this.value = card.getValue();
    }
    //getters
    public int getRankValue(){

        return value.valueRank;
    }
    public Suits getSuit() {

        return suit;
    }
    public Values getValue() {
        return value;
    }
    public String toString() {

        return "["+ value + " of " + suit + "] (" + getRankValue() +")";
    }
}