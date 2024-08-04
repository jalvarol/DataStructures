import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FindMinTest {

	@Test
	void test() {
		BST<Integer> A = new BST<>();
		A.insert(5);
		A.insert(62);
		A.insert(2);
		A.insert(114);
		A.insert(250);
		A.insert(1);
		assertEquals(1,A.findMin());
		A.remove(1);
		assertEquals(2,A.findMin());
		A.remove(2);
		assertEquals(5,A.findMin());
	}

}
