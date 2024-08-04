import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetHeightTest {

	@Test
	void test() {
		BST<Integer> A = new BST<>();
		A.insert(5);
		A.insert(62);
		A.insert(2);
		A.insert(114);
		A.insert(250);
		A.insert(1);
		assertEquals(3,A.getHeight());
		A.remove(250);
		assertEquals(2,A.getHeight());
		A.remove(114);
		A.remove(1);
		A.remove(2);
		A.remove(62);
		assertEquals(0,A.getHeight());
		
	}

}
