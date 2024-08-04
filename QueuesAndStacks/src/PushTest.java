import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PushTest {

	@Test
	void test() {
		Stack<Integer> E = new Stack<>();
		E.push(10);
		assertEquals(10, E.peek());
		E.push(15);
		assertEquals(15, E.peek());
		E.push(20);
		assertEquals(20, E.peek());
		assertEquals(3, E.getLength());
	}

}
