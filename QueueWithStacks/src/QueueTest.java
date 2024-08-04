/**
 * QueueTest.java
 * 
 * @author Jose Alvaro Leos 
 */
import java.util.*;

public class QueueTest {
	public static void main(String[] args) {
		Queue<String> q = new Queue<>();
		System.out.println("**Testing enqueue()**");
		q.enqueue("1");
		System.out.println("Should print 1: " + q);
		q.enqueue("2");
		System.out.println("Should print 1 2: " + q);
		q.enqueue("3");
		System.out.println("Should print 1 2 3: " + q);
		q.enqueue("4");
		System.out.println("Should print 1 2 3 4: " + q);
		q.enqueue("5");
		System.out.println("Should print 1 2 3 4 5: " + q);

		System.out.println("\n**Testing dequeue()**");
		q.dequeue();
		System.out.println("Should print 2 3 4 5: " + q);
		q.dequeue();
		System.out.println("Should print 3 4 5: " + q);
		q.dequeue();
		System.out.println("Should print 4 5: " + q);
		q.dequeue();
		System.out.println("Should print 5: " + q);
		q.dequeue();
		System.out.println("Should print an error message: ");
		try{
			q.dequeue();
		}catch (NoSuchElementException e)
		{
			System.out.println(e);
		}
		q.enqueue("2");
		q.enqueue("3");
		System.out.println("\n**Testing isEmpty()**");
		Queue<String> q2 = new Queue<>();
		System.out.println("Should print true: " + q2.isEmpty());
		System.out.println("Should print false: " + q.isEmpty());
		q2.enqueue("Hello");
		System.out.println("Should print false: " + q2.isEmpty());
		q2.dequeue();
		System.out.println("Should print true: " + q2.isEmpty());

		System.out.println("\n**Testing append()**");
		q2.enqueue("A");
		q2.enqueue("B");
		q2.enqueue("C");
		q2.enqueue("D");
		q.append(q2);
		System.out.println("Should print 2 3 A B C D: " + q);
		Queue<String> qA = new Queue<>();
		qA.enqueue("0");
		qA.enqueue("1");
		qA.append(q);
		System.out.println("Should print 0 1 2 3 A B C D: " + qA);
		Queue<String> qB = new Queue<>();
		qB.enqueue("E");
		qB.enqueue("F");
		qA.append(qB);
		System.out.println("Should print 0 1 2 3 A B C D E F: " + qA);
		Queue<String> qC = new Queue<>();
		qC.append(qA);
		System.out.println("Should print 0 1 2 3 A B C D E F: " + qC);
		
		 System.out.println("\n**Testing getFront()**");
		 System.out.println("Should print A: " + q2.getFront());
		 System.out.println("Should print 0: " + qA.getFront());
		 System.out.println("Should print E: " + qB.getFront());
		 Queue<String> qF = new Queue<>();
		 System.out.println("Should print an error message: " );
		 try {
			 qF.getFront();
		 }catch (NoSuchElementException e)
		 {
			 System.out.println(e);
		 }
		 
		 System.out.println("\n**Testing getSize()**");
		 System.out.println("Should print 6: "  + q.getSize());
		 System.out.println("Should print 10: " + qA.getSize());
		 System.out.println("Should print 2: "  + qB.getSize());
		 
		 System.out.println("\n**Testing Equals**");
		 Queue<String> qT = new Queue<>();
		 Queue<String> qD = new Queue<>(qT);
		 System.out.println("Should print true: " + qT.equals(qD));
		 qT.enqueue("1");
		 System.out.println("Should print false: " + qT.equals(qD));
		 System.out.println("Should print true: " + q2.equals(q2));
		 System.out.println("Should print false: " + q.equals(q2)); 
		 q.dequeue();
		 q.dequeue(); 
		 System.out.println("Should print true: " + q.equals(q2));
		 q.dequeue();
		 
		System.out.println("\n**Testing Copy Constructor**"); 
		Queue<String> q3 = new Queue<String>(q2);
		System.out.println("Should print A B C D: " + q3);
		q3.enqueue("E"); 
		q3.enqueue("F");
		Queue<String> q4 = new Queue<String>(q3);
		System.out.println("Should print A B C D E F: " + q4);
		q4.enqueue("G");
		q4.enqueue("H");
		Queue<String> q5 = new Queue<String>(q4);
		System.out.println("Should print A B C D E F G H: " + q5);
		q5.dequeue();
		q5.dequeue();
		
		
		System.out.println("\nTesting for Deep Copy:");
		System.out.print("Should print A B C D E F: " + q3);
		System.out.print("Should print A B C D: " + q2);
		System.out.print("Should print C D E F G H: " + q5);
		System.out.print("Should print A B C D E F G H: " + q4);
		Queue<String> abc = new Queue<>();	
		System.out.print(abc.getSize());
	}
}