public class BlackjackSolitaire {
	
	/**
	 * Play one hand of Blackjack Solitaire
	 */
	public void play() {
		
		//display initial state of the game
		System.out.println("Welcome to Solitaire! You start with a blank table. This is how it looks:");
		
			//create new table and print the state
			BlackjackSolitaireTable newTable = new BlackjackSolitaireTable();
			newTable.displayTable();
			
		//create & shuffle new deck
		Deck newDeck = new Deck();
		newDeck.shuffle();
		
		// set index of deck to first card
		int cardToBeDealt = 0;
		
		//repeat until no more free slots are available
		while (newTable.hasFreeSlots() == true) {
			
			//deal a card
			Card cardToPlace = newDeck.getCards()[cardToBeDealt];
			cardToPlace.dealCard();
			
			// make a move
			int slotNumber = cardToPlace.placeCard();
			
				// place card in slot
			if ((newTable.changeSlot(slotNumber, cardToPlace.getCardName())) == true) {
				cardToBeDealt++;
			}
		
			//display current state
			newTable.displayTable();
		}		
		
		// when all the 16 slots are taken,	
		// tell the player that the score is being calculated
		System.out.println("Score is being calculated...");
		// calculate the total score
		int totalScore = newTable.calculateTotalScore();
		
		//print message that score is being calculated
		System.out.println("Your total Score is: " + totalScore);
		
		//print message saying the game is done
		System.out.println("The Game is over. Thank you for playing!");	
	}
}
