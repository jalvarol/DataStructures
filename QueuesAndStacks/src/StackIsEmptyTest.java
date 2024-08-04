import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackIsEmptyTest {

	@Test
	void test() {
		Stack<Integer> M = new Stack<>();
		assertTrue(M.isEmpty());
		M.push(15);
		assertFalse(M.isEmpty());
		M.pop();
		assertTrue(M.isEmpty());

	}

}
