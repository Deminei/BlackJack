package com.blackjack;
import java.util.Scanner;
public class Player extends Person{
    Scanner input = new Scanner(System.in);
    public Player(){
        super.setName("Player");
    }

    public void makeDecision(Deck deck, Deck discard){
        int  decision = 0;
        boolean getNum = true;

        while(getNum){
            try{
                System.out.println("Would you like to: 1) Hit or 2) Stand");
                decision = input.nextInt();
                getNum = false;

            }
            catch(Exception e){
                System.out.println("Invalid");
                input.next();
            }
        }
        //if player decides to hit
        if (decision == 1) {
            this.hit(deck, discard);
            //return if they have blackjack or busted
            if(this.getHand().calculatedValue()>20){
                return;
            }
            else{
                this.makeDecision(deck, discard);
            }
        } else if(decision == 2){
            System.out.println("You stand.");
        }

    }

}

