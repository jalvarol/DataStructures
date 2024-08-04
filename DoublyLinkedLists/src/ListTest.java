import java.util.*;

/**
 * Class to test List.java
 * 
 * @author Jose Alvaro Leos
 */
public class ListTest {

	public static void main(String[] args) {

		List<Integer> L = new List<>();
		System.out.println("Should print nothing (an empty list): " + L);

		System.out.println("**Testing addFirst**");
		L.addFirst(2); // Testing Edge case: length == 0
		System.out.println("Should print 2: " + L);
		L.addFirst(1); // Testing General case: length >= 1
		System.out.println("Should print 1 2: " + L);

		L.removeFirst();
		L.removeFirst();
		System.out.println("\n**Testing addLast**");
		L.addLast(5);// Testing Edge case: List isEmpty()
		System.out.println("Should print 5: " + L);
		L.addLast(7);// Testing General case: length >= 1
		System.out.println("Should print 5 7: " + L);

		List<Integer> M = new List<>();
		System.out.println("\n**Testing getFirst**");
		System.out.println("Should print an empty List: " + M);
		System.out.println("Should print an error message for an empty List: ");

		try { // place in a try-catch so program does not end when exception thrown
			M.getFirst(); // Testing Precondition: length == 0
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		M.addFirst(1);// Testing General
		System.out.println("Should print 1: " + M.getFirst());

		System.out.println("\n**Testing getLast**");
		System.out.println("Should print an error message for an empty List: ");
		M.removeFirst();
		try { // place in a try-catch so program does not end when exception thrown
			M.getLast(); // Testing Precondition: length == 0
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		M.addLast(7);// Testing General
		System.out.println("Should print 7: " + L.getLast());

		List<Integer> I = new List<>();
		System.out.println("\n**Testing removeFirst**");
		System.out.println("Should print an empty List: " + I);
		System.out.println("Should print an error message for an empty List: ");
		try { // place in a try-catch so program does not end when exception thrown
			I.removeFirst(); // Testing Precondition: length == 0
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		I.addFirst(3);
		I.addFirst(2);
		I.addFirst(1);
		I.removeFirst(); // Testing General Case: length >1
		System.out.println("Should print 2 3: " + I);
		I.removeFirst(); // Testing Edge Case: length == 1
		System.out.println("Should print 3: " + I.getFirst());
		I.removeFirst();

		System.out.println("\n**Testing removeLast**");
		System.out.println("Should print an empty List: " + I);
		System.out.println("Should print an error message for an empty List: ");
		try {
			I.removeLast(); // Testing Precondition: length == 0
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		I.addLast(1);
		I.addLast(2);
		I.addLast(3);
		I.removeLast(); // Testing General case: length >1
		System.out.println("Should print 1 2: " + I);
		I.removeLast(); // Testing Edge case: length == 1
		System.out.println("Should print 1: " + I.getLast());

		List<Integer> E = new List<>();
		System.out.println("\n**Testing GetIterator**");
		System.out.println("Should print an empty List: " + E);
		System.out.println("Should print an error message for an empty List: ");
		try {
			E.getIterator(); // getIterator() Testing Precondition: length == 0
		} catch (NullPointerException e) {
			System.out.println(e);
		}
		E.addFirst(10);
		E.addFirst(5);
		E.placeIterator();
		System.out.println("Should print a 5: " + E.getIterator()); // Testing General

		List<Integer> F = new List<>();
		System.out.println("\n**Testing PlaceIterator**");
		F.placeIterator();
		System.out.println("Should print an empty list: " + F);
		F.addFirst(20);
		F.addLast(30);
		F.addFirst(10);
		F.placeIterator();// Testing General
		System.out.println("Should print 10: " + F.getIterator());

		List<Integer> B = new List<>();
		System.out.println("\n**Testing AdvanceIterator**");
		System.out.println("Should print an empty List: " + B);
		System.out.println("Should print an error message for an empty List: ");
		try {
			B.advanceIterator();// Testing Precondition: iterator is offEnd
		} catch (NullPointerException e) {
			System.out.println(e);
		}
		B.addFirst(10);
		B.addFirst(5);
		B.placeIterator();
		B.advanceIterator();// TestingGeneral
		System.out.println("Should print 5 10: " + B);
		System.out.println("Should print 10: " + B.getIterator());

		System.out.println("\n**Testing ReverseIterator**");
		List<Integer> C = new List<>();
		System.out.println("Should print an empty List: " + C);
		System.out.println("Should print an error message for an empty List: ");
		try {
			C.reverseIterator();// Testing Precondition: iterator is offEnd
		} catch (NullPointerException e) {
			System.out.println(e);
		}
		C.addLast(2);
		C.addFirst(1);
		C.addLast(3);
		System.out.println("Should print 1 2 3: " + C);
		C.placeIterator();
		C.advanceIterator();
		C.advanceIterator();
		C.reverseIterator();
		System.out.println("Should print 2 : " + C.getIterator());

		List<Integer> K = new List<>();
		System.out.println("\n**Testing addIterator**");
		System.out.println("Should print an empty List: " + K);
		System.out.println("Should print an error message for an empty List: ");
		try {
			K.addIterator(10);// Testing Precondition: iterator is offEnd
		} catch (NullPointerException e) {
			System.out.println(e);
		}
		K.addLast(10);
		K.placeIterator();
		K.addIterator(15);// Testing Edge Case: iterator == last
		System.out.println("Should print 10 15: " + K);
		K.addIterator(20);// Testing General
		System.out.println("Should print 10 20 15 : " + K);
		K.removeIterator();
		K.removeLast();
		K.removeLast();

		System.out.println("\n**Testing removeIterator**");
		System.out.println("Should print an empty List: " + K);
		System.out.println("Should print an error message for an empty List: ");
		try {
			K.removeIterator();// Testing Precondition: iterator is offEnd
		} catch (NullPointerException e) {
			System.out.println(e);
		}
		K.addFirst(1);
		K.addLast(2);
		K.addLast(3);
		K.placeIterator();
		System.out.println("Should print 1 2 3: " + K);
		K.removeIterator();// Testing Edge Case: iterator == first
		System.out.println("Should print 2 3: " + K);
		K.placeIterator();
		K.advanceIterator();
		K.removeIterator();// Testing Edge Case: iterator == last;
		System.out.println("Should print 2: " + K);
		K.addLast(4);
		K.addLast(5);
		K.placeIterator();
		K.addIterator(3);// Testing General
		System.out.println("Should print 2 3 4 5: " + K);

		System.out.println("\n**Testing Copy Constructor**");
		List<String> A = new List<>();// calling default constructor
		for (int i = 0; i <= 10; i++) {
			A.addLast("" + i);
		}
		List<String> Acopy = new List<>(A);// calling copy constructor
		// verify Acopy contains same values as A
		System.out.println("Printing Lcopy: " + Acopy);
		System.out.println("Removing 5 elements from Copy");
		for (int i = 0; i < 5; i++) {
			A.removeLast();
		}
		Acopy = new List<>(A);
		System.out.println("Printing Lcopy: " + Acopy);
		System.out.println("Printing Original: " + A);

		System.out.println("\n**Testing Equals**");
		System.out.println("Should print true: " + A.equals(Acopy));
		Acopy.removeFirst();
		System.out.println("Should print false: " + A.equals(Acopy));

		List<Integer> D = new List<>();
		D.addFirst(9);
		D.addLast(10);
		D.placeIterator();
		D.advanceIterator();
		D.advanceIterator();

		System.out.println("\n**Testing isEmpty**");
		List<Integer> L2 = new List<>();
		System.out.println("Should print true: " + L2.isEmpty());
		List<Integer> L3 = new List<>();
		L3.addFirst(2);
		System.out.println("Should print false: " + L3.isEmpty());

		System.out.println("\n**Testing offEnd**");
		System.out.println("Iterator is offEnd? (true): " + D.offEnd());
		try {
			D.addIterator(10);// testing Precondition
		} catch (NullPointerException e) {
			System.out.println(e);
		}
		List<Integer> L4 = new List<>();
		System.out.println("Should print true: " + L4.offEnd());
		L4.addFirst(10);
		L4.placeIterator();
		System.out.println("Should print false: " + L4.offEnd());

		System.out.println("\n**Testing getLength**");
		System.out.println("Checking L2 length: " + L2.getLength());
		System.out.println("Checking L3 length: " + L3.getLength());

	}
}
