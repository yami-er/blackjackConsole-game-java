package com.textlearn.blackjack.demo;

import java.util.Scanner;

public class Blackjack {

	public static void main(String[] args) {
		//welcome message
		System.out.println("Welcome to Blackjack!");
		
		//create our playing deck
		Deck playingDeck = new Deck();
		playingDeck.createFullDeck();
		playingDeck.shuffle();
		//create a deck for the player
		
		
		Deck playerDeck = new Deck();
		
		Deck dealerDeck = new Deck();
		
		double playerMoney = 100.00;
		
		Scanner userInput = new Scanner(System.in);
		
		//game loop
		while(playerMoney > 0) {
			//play on
			//take the players bet
			System.out.println("You have $" + playerMoney + ", how much would you like to bet?");
			double playerBet = userInput.nextDouble();
			if(playerBet > playerMoney) {
				System.out.println("You cannot bet anymore than you have. please leave!");
				break;
			}
			boolean endRound = false;
			
			//start dealing
			//player gets two cards
			playerDeck.draw(playingDeck);
			
			playerDeck.draw(playingDeck);
			
			//dealer gets two cards
			dealerDeck.draw(playingDeck);
			dealerDeck.draw(playingDeck);
			
			while(true){
				System.out.println("Your hand:");
				System.out.println(playerDeck.toString());
				System.out.println("Your hand is valued at: " + playerDeck.cardsValue());
				
				//display dealer hand
				System.out.println("Dealer Hand:" + dealerDeck.getCard(0).toString() + " and [Hidden]");
				
				//What does the player want to do?
				
				System.out.println("Would you like to (1)Hit or (2) Stand?");
				int response = userInput.nextInt();
			
		//if choose Hit
		if(response == 1) {
			playerDeck.draw(playingDeck);
			System.out.println("You draw a:"+ playerDeck.getCard(playerDeck.deckSize()-1).toString());
			//bust if > 21
			if(playerDeck.cardsValue() > 21){
				System.out.println("Bust.currently valued at: " + playerDeck.cardsValue());
				playerMoney -= playerBet;
				endRound = true;
				break;
				
			}	
	}
		if (response == 2) {
			break;
		}
	}
	
	//reveal dealer cards
			System.out.println("Dealer cards:" + dealerDeck.toString());
			
			//see if dealer has more points
			
			if((dealerDeck.cardsValue() > playerDeck.cardsValue())&& endRound == false){
				System.out.println("Dealer beats you!");
				playerMoney -= playerBet;
				endRound = true;
			}
			//dealer draws at 16, stands at 17
			while((dealerDeck.cardsValue() < 17)&& endRound == false) {
				dealerDeck.draw(playingDeck);
				System.out.println("Dealer Draws:" + dealerDeck.getCard(dealerDeck.deckSize()-1).toString());
			}
			//display total value for dealer\
			System.out.println("Dealer's hand is valued at: " + dealerDeck.cardsValue());
			//determine if dealer busted
			if((dealerDeck.cardsValue() > 21)&& endRound ==false) {
				System.out.println("Dealer busts!  you win.");
				playerMoney += playerBet;
				endRound = true;
			}
			//determine if push
			if((playerDeck.cardsValue() == dealerDeck.cardsValue()) && endRound == false) {
				System.out.println("push");
				endRound = true;
			}
			if((playerDeck .cardsValue() > dealerDeck.cardsValue()) && endRound == false) {
				System.out.println("you win the hand");
				playerMoney += playerBet;
				endRound = true;
				
			}
			else if(endRound == false) {
				System.out.println("You lose the hand.");
				playerMoney -= playerBet;
				endRound = true;
			}
				
			playerDeck.moveAllToDeck(playingDeck);
			dealerDeck.moveAllToDeck(playingDeck);
			System.out.println("End of hand.");
			
		}
			
			System.out.println("Game over! you are out of money.:(");
			
	}
}



		
	


