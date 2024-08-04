import java.io.*;
import java.util.*;

public class BlockChain {

	public static void main(String[] args) throws IOException {
		String filename = "transactions.txt";
		int counter = 0;
		int id = 0;
		String firstName = "";
		String lastName = "";
		String line = "";
		Block info = new Block();
		List <Block> block = new List<>();
		FileReader file = new FileReader(filename);
		BufferedReader buff = new BufferedReader(file);
		boolean eof = false;
		while (!eof) {
			line = buff.readLine();
			counter++;
			if (line == null)
				eof = true;
			else {
				if (counter == 1) {
					id = Integer.parseInt(line);
				}
				if (counter == 2) {
					StringTokenizer st = new StringTokenizer(line);
					firstName = st.nextToken();
					lastName = st.nextToken();
				}
				if (counter == 3) {
					String description = "";
					StringTokenizer ab = new StringTokenizer(line);
					while (ab.hasMoreTokens()) {
						description += ab.nextToken() + " ";
					}
					info = new Block(id, firstName, lastName, description);
					block.addLast(info);

					counter = 0;
				}

			}

		}
		System.out.println("Welcome to Block Chain!\n");
		System.out.println("Total Number of Blocks: " + Block.getNumBlocks() + "\n");
		System.out.println("Would you like to add another transaction (y/n)?");

		String input = "";
		Scanner scan = new Scanner(System.in);
		input = scan.nextLine();
		Scanner descr = new Scanner(System.in);
		while (input.equals("y")) {

			if (input.equals("n")) {
				break;
			}
			System.out.println("Enter the transaction id: ");
			id = scan.nextInt();

			System.out.println("Enter the customer first and last name: ");
			firstName = scan.next();
			lastName = scan.next();

			System.out.println("\nEnter the transaction description: ");

			String desc = descr.nextLine();

			info = new Block(id, firstName, lastName, desc);
			block.addLast(info);
			System.out.println("\nTotal Number of Blocks: " + Block.getNumBlocks() + "\n");
			System.out.println("Would you like to add another transaction (y/n)?");
			scan = new Scanner(System.in);
			input = scan.nextLine();
		}
		System.out.println("Please enter a name for .txt file.");
		Scanner txtFile = new Scanner(System.in);
		String txtFi = txtFile.next();

		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(txtFi), "utf-8"))) {
			writer.write(block.toString());
		} catch (FileNotFoundException e) {
			System.out.println("Error -- " + e.toString());
		}
		System.out.println("\nGoodbye!");
		scan.close();
		descr.close();
		buff.close();
		txtFile.close();
	}

}
