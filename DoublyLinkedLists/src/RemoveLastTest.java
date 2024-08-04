import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RemoveLastTest {

	@Test
	void test() {
		List<Integer> S = new List<>();
		S.addFirst(4);
		S.addFirst(2);
		S.removeLast();
		assertEquals(1, S.getLength());
		S.addFirst(6);
		S.addFirst(7);
		S.addFirst(8);
		S.removeLast();
		assertEquals(3, S.getLength());
		S.removeLast();
		assertEquals(2, S.getLength());
		S.removeLast();
		S.removeLast();
		assertEquals(0, S.getLength());

	}

}
