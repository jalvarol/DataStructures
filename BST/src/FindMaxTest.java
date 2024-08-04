import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FindMaxTest {

	@Test
	void test() {
		BST<Integer> A = new BST<>();
		A.insert(5);
		A.insert(62);
		A.insert(2);
		A.insert(114);
		A.insert(250);
		A.insert(1);
		assertEquals(250, A.findMax());
		A.remove(250);
		assertEquals(114,A.findMax());
		A.remove(114);
		assertEquals(62,A.findMax());
	}

}
