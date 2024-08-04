
/**
 * PalindromeTest.java
 * @author Jose Alvaro Leos
 */

import java.util.*;
import java.io.*;

public class PalindromeTest {
	private Queue<Character> Q = new Queue<Character>();
	private Stack<Character> S = new Stack<Character>();

	public static void main(String[] args) {
		PalindromeTest Pali = new PalindromeTest();

		System.out.print("Welcome!\n\nEnter the name of a file: ");
		boolean found = false;
		while (!found) {
			try {
				Scanner in = new Scanner(System.in);
				String input = "";
				input = in.next();
				FileReader file = new FileReader(input);
				BufferedReader buff = new BufferedReader(file);
				boolean eof = false;
				String str = "";
				System.out.println("\nLabeled Data: \n");
				while (!eof) {
					String test = "";
					str = buff.readLine();
					if (str == null)
						eof = true;
					else {
						test = str.replaceAll("[^A-Za-z0-9]", "");
						test = test.toLowerCase();
						for (int i = 0; i < test.length(); i++) 
						{
							char c = test.charAt(i);
							Pali.S.push(c);
							Pali.Q.enqueue(c);
						}
						boolean check = false;
						while(!Pali.Q.isEmpty()) 
						{
							if(Pali.Q.getFront().equals(Pali.S.peek()))
								{
											Pali.Q.dequeue();
											Pali.S.pop();
								}
							else
							{
								Pali.Q.dequeue();
								Pali.S.pop();
								check = true;
							}
						}

						if(check == false)
						{
							System.out.println(str+" (palindrome)");
						}
						if(check == true)
						{
							System.out.println(str);
						}
						
						
						
					}
					
				}
				found = true;
				buff.close();
				in.close();

			} catch (FileNotFoundException e) {
				System.out.println("Sorry, but I cannot fine a file with that name!");
				System.out.println("\nEnter the name of a file: ");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
