/**
 * Block.java
 * 
 * @author Jose Alvaro Leos
 * @author
 */

public class Block implements Transaction {

	private int transactionId;
	private String firstName;
	private String lastName;
	private String description;
	private long timeStampMillis;
	private long hashNextBlock;
	private static int numBlocks = 0;

	/**
	 * Constructor for a Block
	 * 
	 * @param id          the transaction id
	 * @param first       the customer first name
	 * @param last        the customer last name
	 * @param description the transaction description Calls System's
	 *                    currentTimeMillis() method to assign the timeStampMillis
	 *                    Increases the numBlocks
	 */
	public Block() {
		this.transactionId = 0;
		this.firstName = null;
		this.lastName = null;
		this.description = null;
		timeStampMillis = 0;
		numBlocks = 0;

	}

	public Block(int id, String first, String last, String description) {
		this.transactionId = id;
		this.firstName = first;
		this.lastName = last;
		this.description = description;
		timeStampMillis = System.currentTimeMillis();
		numBlocks++;

	}

	/**
	 * Returns the current number of blocks
	 * 
	 * @return the number of blocks
	 */

	public static int getNumBlocks() {

		return numBlocks;

	}

	/**
	 * Calculates the hash for the next block
	 * 
	 * @param id        the next block's id
	 * @param firstName the customer first name for the next block
	 * @param lastName  the customer last name of the next block
	 */

	public void computeHash(int id, String firstName, String lastName) {

		String name = firstName + lastName;
		int sum = 0;
		for (int i = 0; i < name.length(); i++) {
			sum += name.charAt(i);
		}
		hashNextBlock = sum * 10000 + id;

	}

	/**
	 * toString for the Block class
	 * 
	 * @return a String of Block object
	 *
	 */

	@Override
	public String toString() {
		return "Id: " + transactionId + "\n" + "Name: " + firstName + " " + lastName + "\n" + "Description: "
				+ description + "\n" + "Time Stamp: " + timeStampMillis + "\n" + "Hash of Next Block:"
				+ getHashNextsBlock() + "\n\n";
	}

	@Override
	public int getTransactionId() {
		// TODO Auto-generated method stub
		return transactionId;
	}

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	public long getTimeStampMillis() {
		return timeStampMillis;
	}

	public long getHashNextsBlock() {
		computeHash(transactionId, firstName, lastName);
		return hashNextBlock;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTimeStampMillis(long timeStampMillis) {
		this.timeStampMillis = timeStampMillis;
	}

}