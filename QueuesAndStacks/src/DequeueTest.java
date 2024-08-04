import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DequeueTest {

	@Test
	void test() {
		Queue<Integer> A = new Queue<>();
		A.enqueue(10);
		assertEquals(10, A.getFront());
		A.dequeue();
		A.enqueue(20);
		assertEquals(20, A.getFront());
		A.dequeue();
		A.enqueue(30);
		assertEquals(30, A.getFront());
		A.dequeue();
		assertTrue(A.isEmpty());
	}

}
