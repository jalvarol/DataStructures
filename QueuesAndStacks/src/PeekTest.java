import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PeekTest {

	@Test
	void test() {
		Stack<Integer> C = new Stack<>();
		C.push(10);
		assertEquals(10, C.peek());
		C.push(15);
		assertEquals(15, C.peek());
		C.push(20);
		assertEquals(20, C.peek());
	}

}
