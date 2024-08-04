import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IsEmptyTest {

	@Test
	void test() {
		Queue<String> q = new Queue<>();
		assertTrue(q.isEmpty());
		q.enqueue("Too");
		assertFalse(q.isEmpty());
		q.enqueue("Easy");
		assertFalse(q.isEmpty());
		q.enqueue("JkThisWasPrettyConfusing");
		assertFalse(q.isEmpty());
	}

}
