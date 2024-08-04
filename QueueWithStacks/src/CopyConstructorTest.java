import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CopyConstructorTest {

	@Test
	void test() {
		Queue<String> q4 = new Queue<>();
		q4.enqueue("Hello");
		q4.enqueue("World");
		q4.enqueue("!");
		Queue<String> q3 = new Queue<>(q4);
		assertEquals("Hello",q3.getFront());
		q3.dequeue();
		Queue<String> q2 = new Queue<>(q3);
		assertEquals("World",q2.getFront());
		Queue<String> q1 = new Queue<>(q2);
		q1.dequeue();
		assertEquals("!",q1.getFront());
	}

}
