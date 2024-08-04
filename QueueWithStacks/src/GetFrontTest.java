import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetFrontTest {

	@Test
	void test() {
		Queue<String> q = new Queue<>();
		q.enqueue("It");
		q.enqueue("Appears");
		q.enqueue("to");
		q.enqueue("be");
		q.enqueue("working!");
		assertEquals("It", q.getFront());
		q.dequeue();
		assertEquals("Appears", q.getFront());
		q.dequeue();
		assertEquals("to", q.getFront());

	}

}
