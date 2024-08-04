import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueGetLengthTest {

	@Test
	void test() {
		Queue<Integer> G = new Queue<>();
		G.enqueue(10);
		assertEquals(1, G.getLength());
		G.enqueue(100);
		assertEquals(2, G.getLength());
		G.enqueue(120);
		assertEquals(3, G.getLength());
	}

}
