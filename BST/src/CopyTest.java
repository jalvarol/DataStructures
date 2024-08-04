import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CopyTest {

	@Test
	void test() {
		BST<Integer> A = new BST<>();
		for(int i = 0; i < 20;i++)
		{
			A.insert(i);
		}
		BST<Integer> B = new BST<>(A);
		assertTrue(B.equals(A));
		B.remove(10);
		BST<Integer> C = new BST<>(B);
		assertFalse(C.equals(A));
		assertTrue(C.equals(B));
	}

}
