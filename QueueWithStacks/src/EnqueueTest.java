import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EnqueueTest {

	@Test
	void test() {
		Queue<String> q = new Queue<>();
		q.enqueue("Hello");
		assertEquals("Hello", q.getFront());
		q.enqueue("Bye");
		assertEquals("Hello", q.getFront());
		q.enqueue("It Works");
		assertEquals("Hello", q.getFront());
	}

}
