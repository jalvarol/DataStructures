import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IsEmptyTest {

	@Test
	void test() {
		BST<Integer> A = new BST<>();
		assertTrue(A.isEmpty());
		A.insert(5);
		A.insert(15);
		A.insert(2);
		assertFalse(A.isEmpty());
		A.remove(5);
		A.remove(15);
		A.remove(2);
		assertTrue(A.isEmpty());
	}
}
