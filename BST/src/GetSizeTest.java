import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetSizeTest {

	@Test
	void test() {
		BST<Integer> A = new BST<>();
		assertEquals(0,A.getSize());
		A.insert(5);
		assertEquals(1,A.getSize());
		A.insert(62);
		A.insert(2);
		A.insert(114);
		A.insert(250);
		A.insert(1);
		assertEquals(6,A.getSize());
		A.remove(5);
		assertEquals(5,A.getSize());
		A.remove(62);
		assertEquals(4,A.getSize());
	}

}
