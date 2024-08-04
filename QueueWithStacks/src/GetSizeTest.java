import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetSizeTest {

	@Test
	void test() {
		Queue<String> q = new Queue<>();
		q.enqueue("Hello");
		q.enqueue("Bye");
		q.enqueue("It Works");
		assertEquals(3, q.getSize());
		q.enqueue("Alright");
		assertEquals(4, q.getSize());
		q.dequeue();
		assertEquals(3, q.getSize());

	}

}
