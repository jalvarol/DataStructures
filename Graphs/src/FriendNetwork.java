import java.io.*;
import java.util.*;

public class FriendNetwork {

	public static void main(String[] args) {
		System.out.println("Welcome to the Friend Recommender!");
		System.out.print("\nEnter the name of a file: ");
		int space = 0;
		String input = "";
		Scanner in = new Scanner(System.in);
		input = in.next();

		boolean found = false;
		while (!found) {

			try {
				FileReader file = new FileReader(input);
				BufferedReader buff = new BufferedReader(file);

				String str = "";
				str = buff.readLine();

				int size = Integer.parseInt(str);
				Graph fNetwork = new Graph(size);
				ArrayList<String> names = new ArrayList<String>(size);
				names.add(0, null);

				boolean eof = false;
				while (!eof) {
					str = buff.readLine();
					if (str == null)
						eof = true;
					else {

						int index = Integer.parseInt(str);
						str = buff.readLine();
						names.add(str);
						str = buff.readLine();
						StringTokenizer st = new StringTokenizer(str, " ,");
						while (st.hasMoreTokens()) {
							fNetwork.addUndirectedEdge(index, Integer.parseInt(st.nextToken()));
						}
					}
				}
				if (space > 0) {
					System.out.println();
				}
				System.out.println("Enter Your User Number Below: ");
				for (int i = 1; i <= fNetwork.getNumVertices(); i++) {
					System.out.println(i + ". " + names.get(i));
				}

				System.out.print("\nEnter your choice: ");
				int choice = in.nextInt();

				boolean stop = false;
				while (!stop) {
					System.out.println("\nHere are your current friends: ");
					fNetwork.BFS(choice);
					for (int i = 1; i <= fNetwork.getNumVertices(); i++) {
						if (fNetwork.getParent(i).compareTo(choice) == 0) {
							System.out.println(i + ". " + names.get(i));
						}
					}
					System.out.println("\nHere are your recommended friends: ");
					boolean noFriends = true;
					for (int i = 1; i <= fNetwork.getNumVertices(); i++) {
						if (fNetwork.getDistance(i).compareTo(2) >= 0) {
							System.out.println(i + ". " + names.get(i));
							noFriends = false;
						}

					}
					if (noFriends == true) {
						System.out.println("Sorry! We don't have any recommendations for you at this time.");
						stop = true;
						break;
					}

					System.out.println("\nEnter the number of a friend to add or -1 to quit: ");
					System.out.print("Enter your choice: ");
					int add = in.nextInt();
					if (add == -1) {
						stop = true;
					} else {
						fNetwork.addUndirectedEdge(choice, add);
					}
				}
				System.out.println("\nGoodbye!");
				found = true;
				buff.close();
				in.close();
			} catch (FileNotFoundException e) {
				System.out.println("\nInvalid file name!");
				System.out.print("Enter the name of a file: ");
				input = in.next();
				space++;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
