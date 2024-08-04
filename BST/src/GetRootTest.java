import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetRootTest {

	@Test
	void test() {
		BST<Integer> A = new BST<>();
		A.insert(5);
		A.insert(62);
		A.insert(2);
		A.insert(114);
		A.insert(250);
		A.insert(1);
		assertEquals(5,A.getRoot());
		A.remove(5);
		assertEquals(62,A.getRoot());
		A.remove(62);
		assertEquals(114,A.getRoot());
	}

}
