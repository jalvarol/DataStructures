import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PopTest {

	@Test
	void test() {
		Stack<Integer> D = new Stack<>();
		D.push(10);
		D.push(9);
		D.push(8);
		D.push(7);
		D.push(6);
		D.pop();
		assertEquals(7, D.peek());
		D.pop();
		assertEquals(8, D.peek());
		D.pop();
		assertEquals(9, D.peek());
		assertEquals(2, D.getLength());
	}

}
