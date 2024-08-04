import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DequeueTest {

	@Test
	void test() {
		Queue<String> q = new Queue<>();
		q.enqueue("Hello");
		q.enqueue("World");
		q.enqueue("It Works");
		q.enqueue("Or does it?");
		q.dequeue();
		assertEquals("World", q.getFront());
		q.dequeue();
		assertEquals("It Works", q.getFront());
		q.dequeue();
		assertEquals("Or does it?", q.getFront());
	}

}
