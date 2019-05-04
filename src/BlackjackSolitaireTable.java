public class BlackjackSolitaireTable {
	private String[] table;
	private boolean[] freeSlots;
	
	/**
	 * creates a new table for BlackjackSolitaire
	 * a table has 20 slots for cards, initialized to numbers 1-20
	 * and an array of 20 free slots to track count of placed cards
	 */
	public BlackjackSolitaireTable() {
		this.table = new String[20];
		this.freeSlots = new boolean[20];
		for (int i=0; i<20 ;i++) {
			table[i] = String.valueOf(i+1);
		}
	}
	/**
	 * change the value of a slot in the table
	 * @param slotNumber (the number of the slot to be changed)
	 * @param newItem (the new value of the slot)
	 * @return
	 */
	public boolean changeSlot(int slotNumber, String newItem) {
		if (freeSlots[slotNumber-1] == false) {
			table[slotNumber-1] = newItem;
			freeSlots[slotNumber-1] = true;
			return true;
		} else {
			System.out.println("This slot is already taken.\nPlease choose another slot.");
			return false;
		}		
	}
	
	/**
	 * checks whether there are still free slots in the table
	 * discard pile is ignored
	 * @return true if there are free slots, false otherwise
	 */
	public boolean hasFreeSlots() {
		for (int i=0;i<16;i++) {
			if (freeSlots[i] == false) {
				return true;
			}
		}
		return false;
	}
	
	public String[] getTable() {
		return table;
	}
	
	/**
	 * outputs the blackjack table to the console
	 */
	public void displayTable() {
		System.out.println();
		for (int i=0;i<5;i++) {
			System.out.print(table[i] + "    ");
			
		}
		System.out.println();
		for (int i=5;i<10;i++) {
			System.out.print(table[i] + "    ");
		}
		System.out.println();
		System.out.print("     ");
		for (int i=10;i<13;i++) {
			System.out.print(table[i] + "   ");
		}
		System.out.println();
		System.out.print("     ");
		for (int i=13;i<16;i++) {
			System.out.print(table[i] + "   ");
		}
		System.out.println();
		System.out.println();
		System.out.println("Discard Pile:");
		for (int i=16;i<20;i++) {
			System.out.print(table[i] + "   ");
		}
		System.out.println();
		System.out.println();
	}
	
	public int hasAces() {
		int numberOfAces = 0;
		for (int i=0;i<table.length;i++) {
			if (table[i].charAt(0) == ("A").charAt(0)) {
				numberOfAces++;
			}
		}
		return numberOfAces;
	}
	/**
	 * calculates the score of an array of cards
	 * @return score (int)
	 */
	public int calculateScore(int[] slotsToScore) {
		int numAces = 0;
		int sumValues = 0;
		int score = 0;
		int points = 0;
		
		// the ace can have value 1 or 11 depending on which results in a higher score
		// check for aces in the given slots and determine whether the ace is 1 or 11
		for (int i=0;i<slotsToScore.length;i++) {
			if (Card.getValueByRank(table[slotsToScore[i]-1].substring(0,table[slotsToScore[i]-1].length() - 1)) == 1) {				
				numAces++;
			}
			sumValues += Card.getValueByRank(table[slotsToScore[i]-1].substring(0,table[slotsToScore[i]-1].length() - 1));
		}
		if (numAces == 0 && sumValues < 22) {
			score = sumValues;			
		} else {
			for (int i=numAces;i>0;i--) {
				if ((sumValues + 10*i) < 22) {				
					score = sumValues + 10*i;
				} else if (sumValues < 22) {
					score = sumValues;
				}
			}
		}
			
		//count points according to scores
		// 21 points with two cards = Blackjack
		if (slotsToScore.length == 2 && score == 21) {
			points = 10;
		} else if (score == 21) {
			points = 7;
		} else if (score == 20) {
			points = 5;
		} else if (score == 19) {
			points = 4;
		} else if (score == 18) {
			points = 3;
		} else if (score == 17) {
			points = 2;
		} else if (score == 0) {
			points = 0;
		} else {
			points = 1;
		}
		return points;
	}
	/**
	 * Calculates the total score of the table
	 * @return totalScore (int)
	 */
	public int calculateTotalScore() {
		int[] row1 = {1,2,3,4,5};
		int[] row2 = {6,7,8,9,10};
		int[] row3 = {11,12,13};
		int[] row4 = {14,15,16};
		int[] col1 = {1,6};
		int[] col2 = {2,7,11,14};
		int[] col3 = {3,8,12,15};
		int[] col4 = {4,9,13,16};
		int[] col5 = {5,10};
		int scoreRow1 = this.calculateScore(row1);
		int scoreRow2 = this.calculateScore(row2);
		int scoreRow3 = this.calculateScore(row3);
		int scoreRow4 = this.calculateScore(row4);
		int scoreCol1 = this.calculateScore(col1);
		int scoreCol2 = this.calculateScore(col2);
		int scoreCol3 = this.calculateScore(col3);
		int scoreCol4 = this.calculateScore(col4);
		int scoreCol5 = this.calculateScore(col5);
		int totalScore = scoreRow1+scoreRow2+scoreRow3+scoreRow4+scoreCol1+scoreCol2+scoreCol3+scoreCol4+scoreCol5;
		return totalScore;
	}
/*	
	public static void main(String[] args) {
		BlackjackSolitaireTable testTable = new BlackjackSolitaireTable();
		testTable.changeSlot(1, "AC");
		testTable.changeSlot(2, "7C");
		testTable.changeSlot(3, "2C");
		testTable.changeSlot(4, "2C");
		testTable.changeSlot(5, "AC");
		testTable.changeSlot(6, "10D");
		testTable.changeSlot(7, "2D");
		testTable.changeSlot(8, "3D");
		testTable.changeSlot(9, "7D");
		testTable.changeSlot(10, "10D");
		testTable.changeSlot(11, "5D");
		testTable.changeSlot(14, "3D");
		int[] row1 = {1,2,3,4,5};
		int[] row2 = {6,7,8,9,10};
		int[] row3 = {11,12,13};
		int[] row4 = {14,15,16};
		int[] col1 = {1,6};
		int[] col2 = {2,7,11,14};
		int[] col3 = {3,8,12,15};
		int[] col4 = {4,9,13,16};
		int[] col5 = {5,10};
		int scoreRow1 = testTable.calculateScore(row1);
		int scoreRow2 = testTable.calculateScore(row2);
		int scoreRow3 = testTable.calculateScore(row3);
		int scoreRow4 = testTable.calculateScore(row4);
		int scoreCol1 = testTable.calculateScore(col1);
		int scoreCol2 = testTable.calculateScore(col2);
		int scoreCol3 = testTable.calculateScore(col3);
		int scoreCol4 = testTable.calculateScore(col4);
		int scoreCol5 = testTable.calculateScore(col5);
		int totalScore = scoreRow1+scoreRow2+scoreRow3+scoreRow4+scoreCol1+scoreCol2+scoreCol3+scoreCol4+scoreCol5;
		//System.out.println("Points Row1: " + testTable.calculateScore(row1));
		//System.out.println("Points Row2: " + testTable.calculateScore(row2));
		//System.out.println("Points Row3: " + testTable.calculateScore(row3));
		//System.out.println("Points Row4: " + testTable.calculateScore(row4));
		System.out.println("Points Col1: " + testTable.calculateScore(col1));
		System.out.println("Points Col2: " + testTable.calculateScore(col2));
		//System.out.println("Points Col3: " + testTable.calculateScore(col3));
		//System.out.println("Points Col5: " + testTable.calculateScore(col4));
		System.out.println("Points Col5: " + testTable.calculateScore(col5));
		System.out.println(totalScore);
	}
*/
}
