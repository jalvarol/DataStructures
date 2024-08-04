import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddLastTest {

	@Test
	void test() {
		List<Integer> L = new List<>();
		L.addLast(1);
		assertEquals(1, L.getLast());
		L.addLast(2);
		assertEquals(2, L.getLast());
		L.addLast(3);
		assertEquals(3, L.getLast());
	}

}
