import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EqualsTest {

	@Test
	void test() {
		BST<Integer> A = new BST<>();
		for(int i = 0; i < 20;i++)
		{
			A.insert(i);
		}
		BST<Integer> B = new BST<>(A);
		assertTrue(B.equals(A));
		B.remove(16);
		assertFalse(B.equals(A));
		BST<Integer> C = new BST<>(B);
		assertTrue(C.equals(B));
		
	}

}
