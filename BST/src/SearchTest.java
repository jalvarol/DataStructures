import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SearchTest {

	@Test
	void test() {
		BST<Integer> A = new BST<>();
		A.insert(5);
		A.insert(62);
		A.insert(2);
		A.insert(114);
		A.insert(250);
		A.insert(1);
		assertTrue(A.search(1));
		assertFalse(A.search(100));
		A.remove(114);
		assertFalse(A.search(114));
	}

}
