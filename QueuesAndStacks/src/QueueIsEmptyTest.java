import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueIsEmptyTest {

	@Test
	void test() {
		Queue<Integer> H = new Queue<>();
		assertTrue(H.isEmpty());
		H.enqueue(10);
		assertFalse(H.isEmpty());
		H.dequeue();
		assertTrue(H.isEmpty());
	}

}
