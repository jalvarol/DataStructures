import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueCopyContstructorTest {

	@Test
	void test() {
		Queue<Integer> E = new Queue<>();
		E.enqueue(10);
		Queue<Integer> Ecopy = new Queue<>(E);
		assertEquals(10, Ecopy.getFront());
		Ecopy.enqueue(15);
		Queue<Integer> E2copy = new Queue<>(Ecopy);
		assertEquals(10, E2copy.getFront());
		assertEquals(2, E2copy.getLength());
		E2copy.dequeue();
		E2copy.dequeue();
		E2copy.enqueue(20);
		Queue<Integer> E3copy = new Queue<>(E2copy);
		assertEquals(20, E3copy.getFront());
		assertEquals(1, E3copy.getLength());
	}

}
