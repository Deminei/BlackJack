package com.blackjack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

    private ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<Card>();
    }

    public Deck(boolean makeDeck){
        deck = new ArrayList<Card>();
        if(makeDeck){
            //Go through all the suits
            for(Suits suit : Suits.values()){
                //Go through all the ranks
                for(Values values : Values.values()){
                    //add a new card containing each iterations suit and rank
                    deck.add(new Card(suit, values));
                }
            }
        }
    }
    public ArrayList<Card> getCards() {
        return deck;
    }
    public void shuffleDeck(){
        Collections.shuffle(deck, new Random());
    }
    public Card takeCard(){
        Card cardToTake = new Card(deck.get(0));
        deck.remove(0);
        return cardToTake;

    }
    public boolean hasCards(){
        if (deck.size()>0){
            return true;
        }
        else{
            return false;
        }
    }
    public void emptyDeck(){
        deck.clear();
    }
    public void addCards(ArrayList<Card> cards){
        deck.addAll(cards);
    }
    public void reloadDeckFromDiscard(Deck discard){
        this.addCards(discard.getCards());
        this.shuffleDeck();
        discard.emptyDeck();
        System.out.println("Ran out of cards, creating new deck from discard pile & shuffling deck.");
    }
    public int cardsLeft(){
        return deck.size();
    }
}