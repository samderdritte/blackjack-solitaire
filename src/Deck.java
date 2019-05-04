public class Deck {
	private static Card[] cards = new Card[52];
	
	/**
	 * A Deck of 52 Cards
	 * 4 suits - Clubs, Diamonds, Hearts, Spades
	 * 13 ranks - Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King
	 */
	public Deck() {
		String[] suits = {"C","D","H","S"}; // Clubs, Diamonds, Hearts, Spades
		String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		int[] values = {1,2,3,4,5,6,7,8,9,10,10,10,10}; // every card has a value for the score calculation
		for (int i=0; i<ranks.length; i++) {
			for (int j=0; j<suits.length; j++) {
				Card newCard = new Card(ranks[i],suits[j]);
				newCard.setValue(values[i]);
				cards[(i*4+j)] = newCard;
			}
		}
	}
	/**
	 * Shuffle the Deck
	 */
	public void shuffle() {
		int[] randomDeckOrder = RandomOrderGenerator.getRandomOrder(52);
		Card[] cardsTemp = new Card[52];
		for (int i=0;i<52; i++) {
			cardsTemp[i] = cards[randomDeckOrder[i]-1];
		}
		cards = cardsTemp;
	}
	
	/**
	 * return the Deck of cards
	 * @return cards (an array of 52 Cards)
	 */
	public Card[] getCards() {
		return cards;
	}
	
/*	
	public static void main(String[] args) {
		Deck myDeck = new Deck();
		System.out.println(Arrays.toString(myDeck.getCards()));
		myDeck.shuffle();
		System.out.println(Arrays.toString(myDeck.getCards()));
		myDeck.shuffle();
		System.out.println(Arrays.toString(myDeck.getCards()));
		
		//System.out.println(myDeck.getCards()[1].getCardName());
	}
*/
}
