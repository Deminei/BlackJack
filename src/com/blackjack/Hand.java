package com.blackjack;
import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;

    public Hand(){
        hand = new ArrayList<Card>();
    }

    public void takeCardFromDeck(Deck deck){
        hand.add(deck.takeCard());
    }

    //calculates  the value of the hands
    public int calculatedValue(){
        //variables to count number of aces, and current total value
        int value = 0;
        int aceCount = 0;

        //For each card in this hand
        for(Card card: hand){
            //adds the card value to the hand
            value += card.getRankValue();
            //counts how many aces have been added
            if (card.getRankValue() == 11){
                aceCount ++;
            }
        }
        //if multiple aces, goes back and sets each ace to 1 until under 21, if possible
        if (value > 21 && aceCount > 0){
            while(aceCount > 0 && value > 21){
                aceCount --;
                value -= 10;
            }
        }
        return value;
    }

    //prints player hand
    public String toString(){
        String output = "";
        for(Card card: hand){
            output += card + " - ";
        }
        return output;
    }

    public Card getCard(int idx){
        return hand.get(idx);
    }
    public void discardHandToDeck(Deck discardDeck){

        //copy cards from hand to discardDeck
        discardDeck.addCards(hand);

        //clear the hand
        hand.clear();

    }
}
