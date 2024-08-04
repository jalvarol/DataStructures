import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EqualsTest {

	@Test
	void test() {
		Queue<String>q = new Queue<String>();
		q.enqueue("Lion");
		q.enqueue("Elephant");
		q.enqueue("Jaguar");
		q.enqueue("Tiger");
		q.enqueue("Zebra");
		Queue<String>q2 = new Queue<String>(q);
		assertTrue(q2.equals(q));
		q2.dequeue();
		assertFalse(q2.equals(q));
		Queue<String>q3 = new Queue<String>(q2);
		assertTrue(q3.equals(q2));
		
		
	}

}
