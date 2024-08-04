/**
 * Card.java
 * 
 * @author Jose Leos
 */

public class Card implements Comparable<Card> {
	private String rank;
	private String suit;

	/**
	 * Constructor for the Card class
	 * 
	 * @param rank the rank of card from 2 to A
	 * @param suit the suit of card C, D, H, or S
	 */
	public Card(String rank, String suit) {
		this.rank = rank;
		this.suit = suit;
	}

	/**
	 * Returns the card's rank
	 * 
	 * @return rank a rank from 2 (low) to A (high)
	 */
	public String getRank() {
		return this.rank;
	}

	/**
	 * Returns the card's suit
	 * 
	 * @return C, D, H, or S
	 */
	public String getSuit() {
		return this.suit;
	}

	/**
	 * Updates the card's rank
	 * 
	 * @param rank a new rank
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}

	/**
	 * Updates the card's suit
	 * 
	 * @param suit the new suit
	 */
	public void setSuit(String suit) {
		this.suit = suit;
	}

	/**
	 * Concatenates rank and suit
	 */
	@Override
	public String toString() {
		return this.rank + this.suit;
	}

	/**
	 * Overrides the equals method for Card Compares rank and suit and follows the
	 * equals formula given in Lesson 4 and also in Joshua Block's text
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof Card)) {
			return false;
		} else {
			Card L = (Card) o;
			if (this.getRank() != L.getRank()) {
				return false;
			} else {
				if (this.getSuit() != L.getSuit()) {
					return false;
				}
			}
			return true;
		}

	}

	/**
	 * Orders two cards first by suit (alphabetically) Next by rank. "A" is
	 * considered the high card Order goes 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A
	 * 
	 * @return a negative number if this comes before c and a positive number if c
	 *         comes before this and 0 if this and c are equal according to the
	 *         above equals method
	 */
	@Override
	public int compareTo(Card c) {

		String rankNumber1 = "";
		String rankNumber2 = "";
		char ch = this.getSuit().charAt(0);
		char dh = c.getSuit().charAt(0);

		int suit1 = ch;
		int suit2 = dh;

		if ("A".equals(this.getRank())) {
			rankNumber1 = "14";
		} else if ("K".equals(this.getRank())) {
			rankNumber1 = "13";
		}

		else if ("Q".equals(this.getRank())) {
			rankNumber1 = "12";
		} else if ("J".equals(this.getRank())) {
			rankNumber1 = "11";
		}

		if ("A".equals(c.getRank())) {
			rankNumber2 = "14";
		} else if ("K".equals(c.getRank())) {
			rankNumber2 = "13";
		}

		else if ("Q".equals(c.getRank())) {
			rankNumber2 = "12";
		} else if ("J".equals(c.getRank())) {
			rankNumber2 = "11";
		}

		if (suit1 == suit2) {

			if (rankNumber1 == rankNumber2) {
				return 0;
			} else if (rankNumber1.compareTo(rankNumber2) < 0) {
				return 1;
			} else
				return -1;
		} else if (suit1 < suit2) {
			return -1;
		} else
			return 1;

	}
}
