import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OffEndTest {

	@Test
	void test() {
		List<Integer> M = new List<>();
		assertTrue(M.offEnd());
		M.addFirst(15);
		M.placeIterator();
		assertFalse(M.offEnd());
		M.removeIterator();
		assertTrue(M.offEnd());
	}

}
