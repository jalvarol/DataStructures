import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackEqualsTest {

	@Test
	void test() {
		Stack<Integer> J = new Stack<>();
		J.push(10);
		J.push(20);
		J.push(50);
		Stack<Integer> Jcopy = new Stack<>(J);
		assertTrue(J.equals(Jcopy));
		Jcopy.pop();
		assertFalse(Jcopy.equals(J));
		Jcopy.push(50);
		assertTrue(J.equals(Jcopy));
	}

}
