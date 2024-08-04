import java.util.NoSuchElementException;

/**
 * Class to test Stack.java
 * 
 * @author Jose Alvaro Leos
 */
public class StackTest {
	public static void main(String[] args) {

		System.out.println("\n**Testing Push**");
		Stack<Integer> A = new Stack<>();
		System.out.println("Should print nothing (an empty list): " + A);
		A.push(1);
		System.out.println("Should print 1: " + A);
		A.push(2);
		System.out.println("Should print 2 1: " + A);

		System.out.println("\n**Testing Pop**");
		Stack<Integer> B = new Stack<>();
		System.out.println("Should print nothing (an empty list): " + B);
		System.out.println("Should print an error message for an empty List: ");
		try { // place in a try-catch so program does not end when exception thrown
			B.pop(); // Testing Precondition: length == 0
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		B.push(1);
		B.push(2);
		System.out.println("Should print 2 1: " + B);
		B.pop();
		System.out.println("Should print 1: " + B);

		System.out.println("\n**Testing GetFront**");
		Stack<Integer> C = new Stack<>();
		System.out.println("Should print nothing (an empty list): " + C);
		System.out.println("Should print an error message for an empty List: ");
		try { // place in a try-catch so program does not end when exception thrown
			C.peek(); // Testing Precondition: length == 0
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		C.push(1);
		C.push(2);
		C.push(3);
		System.out.println("Should print 3: " + C.peek());

		System.out.println("\n**Testing GetLength**");
		Stack<Integer> D = new Stack<>();
		System.out.println("Should print nothing (an empty list): " + D);
		D.push(1);
		D.push(2);
		System.out.println("Should print 2: " + D.getLength());
		D.pop();
		D.pop();
		System.out.println("Should print 0: " + D.getLength());

		System.out.println("\n**Testing IsEmpty**");

		Stack<Integer> E = new Stack<>();
		System.out.println("Should print nothing (an empty list): " + E);
		System.out.println("Should print true: " + E.isEmpty());
		E.push(1);
		System.out.println("Should print false: " + E.isEmpty());

		System.out.println("\n**Testing CopyConstructor**");
		Stack<Integer> F = new Stack<>();
		System.out.println("Should print nothing (an empty list): " + F);
		F.push(1);
		F.push(2);
		F.push(3);
		F.push(4);
		F.push(5);
		Stack<Integer> Fcopy = new Stack<>(F);
		System.out.println("Should print 5 4 3 2 1: " + Fcopy);
		Fcopy.pop();
		Stack<Integer> F2copy = new Stack<>(Fcopy);
		System.out.println("Should print 4 3 2 1: " + F2copy);

		System.out.println("\n**Testing Equals**");
		Stack<Integer> G = new Stack<>();
		G.push(1);
		G.push(2);
		G.push(3);
		G.push(4);
		G.push(5);
		Stack<Integer> Gcopy = new Stack<>(G);
		System.out.println("Should print true: " + Gcopy.equals(G));
		Gcopy.pop();
		System.out.println("Should print false: " + Gcopy.equals(G));

	}

}
