import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EnqueueTest {

	@Test
	void test() {
		Queue<Integer> B = new Queue<>();
		B.enqueue(10);
		B.enqueue(20);
		B.enqueue(30);
		B.enqueue(40);
		B.dequeue();
		assertEquals(20, B.getFront());
		B.dequeue();
		assertEquals(30, B.getFront());
		B.dequeue();
		assertEquals(40, B.getFront());
	}

}
