import java.util.InputMismatchException;
import java.util.Scanner;

public class Card {
	private String suit;
	private String rank;
	private int value;
	private String cardName;
	
	/**
	 * A card has a rank and a suit
	 * @param rank
	 * @param suit
	 */
	public Card(String rank, String suit) {
		this.rank = rank;
		this.suit = suit;
		this.cardName = rank+suit;
	}
	/**
	 * deals a new card to the player
	 * @param indexOfCardInDeck the index of the card in the deck, 
	 * 		with the 0th card begin the first card to be dealt
	 * @param cardDeck, an Deck of Cards (an array)
	 */
	public void dealCard() {
		System.out.print("Here is your card: ");
		System.out.println(cardName + "\n");
		//System.out.print("Card value: "+value);
	}
	
	/**
	 * Ask the player to place his card in a slot
	 * @return the slot for the card (an integer)
	 */
	public int placeCard() {
		System.out.print("Choose a slot for your card: ");
		Scanner s = new Scanner(System.in);
		int slot = -1;
		boolean input = false; 
		while (!input) {	
			// catch inputExeption to avoid non-integer inputs
			try {
				slot = s.nextInt();
				while (slot < 1 || slot > 20) {			
					if (slot < 1 || slot > 20) {
						System.out.print("Please choose a slot between 1 & 20. ");
						slot = s.nextInt();
					}
				}
				input = true;
			} catch (InputMismatchException e) {
				s.next();
				System.out.print("This is not an integer.\nPlease enter an integer between 1 & 20. ");
			}
		}
		return slot;
		
	}
	
	public String getSuit() {
		return suit;
	}
	public String getRank() {
		return rank;
	}
	public int getValue() {
		return value;
	}
	public static int getValueByRank(String rank) {
		String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		int[] values = {1,2,3,4,5,6,7,8,9,10,10,10,10};
		for (int i=0;i<ranks.length;i++) {
			if (rank.equals(ranks[i])){
				return values[i];
			}
		} return 99;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public String getCardName() {
		return cardName;
	}

/*
	public static void main(String[] args) {
		Card myCard = new Card("A", "H");
		System.out.println(myCard.getCardName());
	}
*/	
}
