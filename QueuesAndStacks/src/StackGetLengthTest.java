import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackGetLengthTest {

	@Test
	void test() {
		Stack<Integer> K = new Stack<>();
		K.push(100);
		assertEquals(1, K.getLength());
		K.push(50);
		assertEquals(2, K.getLength());
		K.push(100);
		K.push(400);
		K.push(450);
		K.pop();
		assertEquals(4, K.getLength());

	}

}
