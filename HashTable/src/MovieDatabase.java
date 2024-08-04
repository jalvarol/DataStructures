/**
 * MovieDatabase.java
 * @author Jose Alvaro Leos
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class MovieDatabase {
    private final int NUM_MOVIES = 26;
    Hash<Movie> ht = new Hash<>(NUM_MOVIES * 2);
    BST<Movie> bst = new BST<>();
    
    public static void main(String[] args) throws IOException {
    	
    	MovieDatabase s1 = new MovieDatabase();
    	Movie take = null;
        File file = new File("movies.txt");
     try {
        Scanner input = new Scanner(file);
        System.out.println("Welcome to the Bond Movie Database!\n");

        while(input.hasNextLine())
        	{     
        		String title = input.nextLine();	
        		String director = input.nextLine();  
        		int year = Integer.parseInt(input.nextLine());		
        		double grossMillions = Double.parseDouble(input.nextLine());
        		take = new Movie(title,director,year,grossMillions);
        		s1.ht.insert(take);
        		s1.bst.insert(take);
        		
        		if(input.hasNextLine()) 
        		{
        			input.nextLine();
        		}
        	
        	}
        boolean go = true;
        while(go)
        {
        	Scanner read = new Scanner(System.in);
        	
        	System.out.println("\nPlease select from one of the following options:\n");
        	System.out.println("A. Add a Movie\n"+
        					   "D. Display all Movies\n"+
        					   "R. Remove a Movie\n"+
        					   "S. Search for a Movie\n"+
        					   "X. Exit\n");
        	System.out.print("Enter your choice: ");
        	char ch = read.nextLine().charAt(0);
        	if(ch == 'A')
        	{
        		System.out.println("\nAdding a movie!\n");
        		System.out.print("Enter the title: ");
        		String aTitle = read.nextLine();
        		System.out.print("Enter the director: ");
        		String aDirector = read.nextLine();
        		System.out.print("Enter the year: ");
        		int aYear = Integer.parseInt(read.nextLine());
        		System.out.print("Enter the gross in millions: ");
        		String arGross = read.nextLine();
        		arGross = arGross.replaceAll("[^0-9.]","");
        		double aGross = Double.parseDouble(arGross);
        		Movie add = new Movie(aTitle,aDirector,aYear,aGross);
        		s1.ht.insert(add);
        		s1.bst.insert(add);
        		
        		System.out.println("\n"+aTitle+" was added!");
        	}
        	else if(ch =='D')
        	{
        		System.out.println("\nPlease select one of the following options:\n\n"+
        						   "S. Sorted\n"+
        						   "U. Unsorted\n");
        		System.out.print("Enter your choice: ");
        		ch = read.nextLine().charAt(0);
        		if(ch == 'U')
        		{
        			System.out.println("\nDisplaying Movies: ");
        			System.out.print("\n"+s1.ht.toString());
        		}
        		else if(ch == 'S')		
        		{
        			System.out.println("\nDisplaying Movies: ");
        			s1.bst.inOrderPrint();
        		}
        		else
        		{
        			System.out.println("\nInvalid Selection!");
        		}
        	}
        	else if(ch =='R')
        	{       
        		
        		System.out.println("\nRemoving a movie!\n");
        		System.out.print("Enter the title: ");
        		String rTitle = read.nextLine();
        		System.out.print("Enter the director: ");
        		String rDirector = read.nextLine();
        		Movie delete = new Movie(rTitle,rDirector,0,0);
        		if(s1.bst.search(delete))
        		{
        			System.out.println("\n"+rDirector+"'s "+rTitle+" was removed!");
        			s1.bst.remove(delete);
        			s1.ht.remove(delete);
        		}
        		else
        			System.out.println("\nI cannot find "
        							+rDirector+"'s "+rTitle+" in the database.");
        		

        	}
        	else if(ch =='S')
        	{
        		System.out.println("\nSearching for a movie!\n");
        		System.out.print("Enter the title: ");
        		String rTitle = read.nextLine();
        		System.out.print("Enter the director: ");
        		String rDirector = read.nextLine();
        		Movie search = new Movie(rTitle,rDirector,0,0);
        		if(s1.bst.search(search))
        		{
        			System.out.println("\n"+rDirector+"'s "+rTitle+" is in the database!");
        		}
        		else
        		
        			System.out.println("\n"+rDirector+"'s "+rTitle+" is not in the database");        		  		
        	}	
        	else if(ch =='X')
        	{
        		go = false;
        		read.close();
        	}
        	else
        	{
        		System.out.println("\nInvalid Selection!");
        	}

        }
        
        System.out.println("\nGoodbye!");   
        input.close();
     	}    
        catch(IOException e )
        {
        	e.printStackTrace();
        }
    }
}