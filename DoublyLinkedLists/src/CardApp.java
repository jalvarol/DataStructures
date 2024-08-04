
/**
 * CardApp.java
 * @author Jose Leos
 */

import java.util.Scanner;
import java.io.*;

public class CardApp {

	private List<Card> L = new List<>();

	public static void main(String[] args) throws IOException {

		CardApp L2 = new CardApp();

		System.out.println("Welcome!\n\n");

		System.out.println("Enter the name of the file containing a deck of cards: ");

		Scanner in = new Scanner(System.in);

		String input = "";
		input = in.next();
		while (true) {
			try {
				FileReader file = new FileReader(input);
				BufferedReader buff = new BufferedReader(file);
				String rank = "";
				String suit = "";
				String line = "";
				Card L3;
				boolean eof = false;
				while (!eof) {
					line = buff.readLine();
					if (line == null)
						eof = true;
					else {

						if (line.substring(0, 1).contentEquals("1")) {
							rank = line.substring(0, 2);
							suit = Character.toString(line.charAt(2));
							L3 = new Card(rank, suit);
							L2.L.addLast(L3);
						} else {
							rank = Character.toString(line.charAt(0));
							suit = Character.toString(line.charAt(1));
							L3 = new Card(rank, suit);
							L2.L.addLast(L3);
						}
					}
				}
				buff.close();
				break;
			}

			catch (IOException e) {
				System.out.print("Invalid file name. Please enter a valid file name: ");
				input = in.next();
			}
		}
		L2.shuffle();
		String txtFi = "shuffled.txt";
		try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(txtFi), "utf-8"))) {
			writer.write(L2.L.toString());
		} catch (FileNotFoundException e) {
			System.out.println("Error -- " + e.toString());
		}

		L2.sort();
		String txtFiSt = "sorted.txt";
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(txtFiSt), "utf-8"))) {
			writer.write(L2.L.toString());
		} catch (FileNotFoundException e) {
			System.out.println("Error -- " + e.toString());
		}

		System.out.println("Please open shuffled.txt and sorted.txt.");

		in.close();
		return;
	}

	/**
	 * Shuffles cards following this algorithm: First swaps first and last card
	 * Next, swaps every even card with the card 3 nodes away from that card. Stops
	 * when it reaches the 3rd to last node Then, swaps ALL cards with the card that
	 * is 3 nodes away from it, stopping at the 3rd to last node
	 */
	public void shuffle() {
		for (int i = 1; i < L.getLength() - 2; i++) {
			if (i == 1) { // swapping first and last elements
				Card temp = L.getLast();
				L.removeLast();
				L.addLast(L.getFirst());
				L.removeFirst();
				L.addFirst(temp);
			}
			if (i % 2 == 0) {
				L.placeIterator();
				for (int j = 1; j < i; j++) {
					L.advanceIterator();
				}
				Card temp = L.getIterator();
				for (int k = 0; k < 3; k++)// L traverses 3 spots ahead
				{
					L.advanceIterator();
					if (L.offEnd())// If L is null, we stop
					{
						break;
					}
				}
				L.addIterator(temp); // Swap L element with temp
				temp = L.getIterator();
				L.removeIterator();
				L.placeIterator();
				for (int l = 1; l < i; l++)// Return L to its correct index
				{
					L.advanceIterator();
				}
				L.addIterator(temp);
				L.removeIterator();

			}

		}

		for (int i = 1; i < L.getLength() - 2; i++) {
			L.placeIterator();
			for (int j = 0; j < i; j++) {
				L.advanceIterator();
			}
			Card temp = L.getIterator();

			for (int k = 0; k < 3; k++) {
				L.advanceIterator();

			}
			if (L.offEnd()) {
				break;
			}
			L.addIterator(temp);
			temp = L.getIterator();
			L.removeIterator();
			L.placeIterator();
			for (int l = 0; l < i; l++) {
				L.advanceIterator();
			}
			L.addIterator(temp);
			L.removeIterator();

		}
	}

	/**
	 * Implements the bubble sort algorithm to sort L into sorted order, first by
	 * suit (alphabetical order) then by rank from 2 to A
	 */
	public void sort() {
		boolean swapped;
		Card temp;
		Card temp2;
		for (int i = 0; i <= L.getLength() - 2; i++) {
			swapped = false;
			L.placeIterator();
			temp = L.getIterator();
			L.advanceIterator();
			temp2 = L.getIterator();
			for (int j = 0; j <= L.getLength() - i - 2; j++) {
				if (temp.compareTo(temp2) > 0)// If the first Card comes after (Returns a 1), we need to swap
				{
					L.addIterator(temp);// Add the Card to come after
					L.reverseIterator();// Reverse to the original Card
					L.removeIterator();// Remove the original card
					L.placeIterator();
					for (int k = 0; k <= j; k++)// Start the iteration up to the recently swapped card
					{
						L.advanceIterator();
					}
					temp = L.getIterator();
					L.advanceIterator();
					if (L.offEnd()) {
						break;
					}
					temp2 = L.getIterator();
					swapped = true;
				} else if (temp.compareTo(temp2) < 0) {
					temp = temp2;
					L.advanceIterator();
					temp2 = L.getIterator();
				}
			}
			if (swapped == false)// break the loop if cards werent swapped in the inner loop
			{
				break;
			}

		}

	}

}
