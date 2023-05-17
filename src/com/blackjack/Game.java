package com.blackjack;

public class Game {
    private Deck deck, discarded;

    private Dealer dealer;
    private Player player;
    private int wins, losses, pushes;

    public Game(){
        //makes a new deck with 52 cards
        deck = new Deck(true);
        //make a new empty deck
        discarded = new Deck();

        //creates the People
        dealer = new Dealer();
        player = new Player();

        //shuffles the deck and starts the first round
        deck.shuffleDeck();
        startRound();
    }

    //method w/logic for each round
    private void startRound(){
        if(wins>0 || losses>0 || pushes>0){
            System.out.println();
            System.out.println("Starting Next Round... Wins: " + wins + " Losses: "+ losses+ " Pushes: "+pushes);
            dealer.getHand().discardHandToDeck(discarded);
            player.getHand().discardHandToDeck(discarded);
        }

        //makes sure deck has at least 4 cards left
        if(deck.cardsLeft() < 4){
            deck.reloadDeckFromDiscard(discarded);
        }

        //give dealer two cards
        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);

        //give player two cards
        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);

        //prints their hands
        dealer.printFirstHand();
        player.printHand();

        //checks if either has blackjack at start
        if(dealer.hasBlackjack()){
            dealer.printHand();

            //checks if player also has BlackJack ends round with a push
            if(player.hasBlackjack()){
                System.out.println("You both have 21 - Push.");
                pushes++;
                startRound();
            }
            else{
                System.out.println("Dealer has BlackJack. You lose.");
//                dealer.printHand();
                losses++;
                startRound();
            }
        }
        if(player.hasBlackjack()){
            System.out.println("You have Blackjack! You win!");
            wins++;
            startRound();
        }
        //lets player decide
        player.makeDecision(deck, discarded);

        //checks if busted
        if(player.getHand().calculatedValue() > 21){
            System.out.println("You have gone over 21.");
            //count the losses
            losses ++;
            //start the round over
            startRound();
        }
        //dealer's turn
        dealer.printHand();
        while(dealer.getHand().calculatedValue()<17){
            dealer.hit(deck, discarded);
        }

        //check who wins
        if(dealer.getHand().calculatedValue()>21){
            System.out.println("Dealer busts");
            wins++;
        }
        else if(dealer.getHand().calculatedValue() > player.getHand().calculatedValue()){
            System.out.println("You lose.");
            losses++;
        }
        else if(player.getHand().calculatedValue() > dealer.getHand().calculatedValue()){
            System.out.println("You win.");
            wins++;
        }
        else{
            System.out.println("Push.");
            pushes++;
        }
        startRound();

    }
}
