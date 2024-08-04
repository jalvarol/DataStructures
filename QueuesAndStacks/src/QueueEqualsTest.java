import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueEqualsTest {

	@Test
	void test() {
		Queue<Integer> F = new Queue<>();
		F.enqueue(10);
		F.enqueue(20);
		F.enqueue(30);
		Queue<Integer> Fcopy = new Queue<>(F);
		assertTrue(F.equals(Fcopy));
		Queue<Integer> F2copy = new Queue<>(Fcopy);
		assertTrue(F.equals(F2copy));
		F2copy.dequeue();
		assertFalse(F2copy.equals(Fcopy));

	}

}
