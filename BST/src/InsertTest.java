import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InsertTest {

	@Test
	void test() {
		BST<Integer> A = new BST<>();
		A.insert(5);
		assertEquals(5,A.getRoot());
		A.insert(62);
		assertEquals(62,A.findMax());
		A.insert(2);
		assertEquals(2,A.findMin());
	
	}

}
