import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppendTest {

	@Test
	void test() {
		Queue<String> q = new Queue<>();
		Queue<String> q2 = new Queue<>();
		q.enqueue("Hi");
		q2.enqueue("Hello");
		q.append(q2);
		q.dequeue();
		assertEquals("Hello", q.getFront());
		q2.enqueue("BYE");
		q2.enqueue("See you later");
		q.append(q2);
		q.dequeue();
		assertEquals("Hello", q.getFront());
		q.dequeue();
		assertEquals("BYE", q.getFront());
	}

}
