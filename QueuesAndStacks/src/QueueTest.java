import java.util.*;

/**
 * Class to test Queue.java
 * 
 * @author Jose Alvaro Leos
 */
public class QueueTest {
	public static void main(String[] args) {

		System.out.println("\n**Testing Enqueue**");
		Queue<Integer> A = new Queue<>();
		System.out.println("Should print nothing (an empty list): " + A);
		A.enqueue(1);
		System.out.println("Should print 1: " + A);
		A.enqueue(2);
		System.out.println("Should print 1 2: " + A);

		System.out.println("\n**Testing Dequeue**");
		Queue<Integer> B = new Queue<>();
		System.out.println("Should print nothing (an empty list): " + B);
		System.out.println("Should print an error message for an empty List: ");
		try { // place in a try-catch so program does not end when exception thrown
			B.dequeue(); // Testing Precondition: length == 0
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		B.enqueue(1);
		B.enqueue(2);
		System.out.println("Should print 1 2: " + B);
		B.dequeue();
		System.out.println("Should print 2: " + B);

		System.out.println("\n**Testing GetFront**");
		Queue<Integer> C = new Queue<>();
		System.out.println("Should print nothing (an empty list): " + C);
		System.out.println("Should print an error message for an empty List: ");
		try { // place in a try-catch so program does not end when exception thrown
			C.getFront(); // Testing Precondition: length == 0
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		C.enqueue(1);
		C.enqueue(2);
		C.enqueue(3);
		System.out.println("Should print 1: " + C.getFront());

		System.out.println("\n**Testing GetLength**");
		Queue<Integer> D = new Queue<>();
		System.out.println("Should print nothing (an empty list): " + D);
		D.enqueue(1);
		D.enqueue(2);
		System.out.println("Should print 2: " + D.getLength());
		D.dequeue();
		D.dequeue();
		System.out.println("Should print 0: " + D.getLength());

		System.out.println("\n**Testing IsEmpty**");

		Queue<Integer> E = new Queue<>();
		System.out.println("Should print nothing (an empty list): " + E);
		System.out.println("Should print true: " + E.isEmpty());
		E.enqueue(1);
		System.out.println("Should print false: " + E.isEmpty());

		System.out.println("\n**Testing CopyConstructor**");
		Queue<Integer> F = new Queue<>();
		System.out.println("Should print nothing (an empty list): " + F);
		F.enqueue(1);
		F.enqueue(2);
		F.enqueue(3);
		F.enqueue(4);
		F.enqueue(5);
		Queue<Integer> Fcopy = new Queue<>(F);
		System.out.println("Should print 1 2 3 4 5: " + Fcopy);
		Fcopy.dequeue();
		Queue<Integer> F2copy = new Queue<>(Fcopy);
		System.out.println("Should print 2 3 4 5: " + F2copy);

		System.out.println("\n**Testing Equals**");
		Queue<Integer> G = new Queue<>();
		G.enqueue(1);
		G.enqueue(2);
		G.enqueue(3);
		G.enqueue(4);
		G.enqueue(5);
		Queue<Integer> Gcopy = new Queue<>(G);
		System.out.println("Should print true: " + Gcopy.equals(G));
		Gcopy.dequeue();
		System.out.println("Should print false: " + Gcopy.equals(G));

	}

}
