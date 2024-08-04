import java.util.*;
/**
 * Class to test List.java
 * @author Jose Leos
 */
public class ListTest {

	public static void main(String[] args) {
        List<Integer> L = new List<>();
        System.out.println("Should print nothing (an empty list): " + L);      
        
        System.out.println("**Testing addFirst**"); 
        L.addFirst(2); //Testing Edge case: length == 0
        System.out.println("Should print 2: " + L);
        L.addFirst(1); //Testing General case: length >= 1
        System.out.println("Should print 1 2: " + L);
        

        System.out.println("**Testing addLast**"); 
        L.addLast(5);
        System.out.println("Should print 1 2 5: " + L);
        L.addLast(7);
        System.out.println("Should print 1 2 5 7: " + L);
        
        System.out.println("**Testing removeFirst**");
        L.removeFirst(); //Testing General case: length >1
        System.out.println("Should print 2 5 7: " + L);
        L.removeFirst(); //Testing Edge case: length == 1
        System.out.println("Should print 5 7: " + L);
        L.removeFirst();
        L.removeFirst();
        System.out.println("Should print an empty List: " + L);
        System.out.println("Should print an error message for an empty List: ");
        
        try { //place in a try-catch so program does not end when exception thrown
            L.removeFirst(); //Testing Precondition: length == 0
        } catch(NoSuchElementException e) {
            System.out.println(e.getMessage());
        } 
        
        System.out.println("**Testing removeLast**");      
        L.addFirst(2); 
        L.addFirst(1);
        L.removeLast();
        System.out.println("Should print 1: " + L);       
        L.removeLast();
        System.out.println("Should print an empty List: " + L);
        System.out.println("**Testing isEmpty**");
        List<Integer> L2 = new List<>();
        System.out.println("Should print true: " + L2.isEmpty());
        List<Integer> L3 = new List<>();
        	 L3.addFirst(2);
        System.out.println("Should print false: " + L3.isEmpty());
        
        System.out.println("**Testing getLength**");      
        System.out.println("Checking L2 length: " +L2.getLength());
        System.out.println("Checking L3 length: " +L3.getLength());

	}

}
/*

Should print nothing (an empty list): 
**Testing addFirst**
Should print 2: 2 
Should print 1 2: 1 2 
**Testing addLast**
Should print 1 2 5: 1 2 5 
Should print 1 2 5 7: 1 2 5 7 
**Testing removeFirst**
Should print 2 5 7: 2 5 7 
Should print 5 7: 5 7 
Should print an empty List: 
Should an error message for an empty List: 
removeFirst(): List is empty. No data to access!
**Testing removeLast**
Should print 1: 1 
Should print an empty List: 
**Testing isEmpty**
Should print true: true
Should print false: false
**Testing getLength**
Checking L2 length: 0
Checking L3 length: 1
*/