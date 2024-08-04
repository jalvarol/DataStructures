import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddIteratorTest {

	@Test
	void test() {
		List<Integer> N = new List<>();
		N.addFirst(1);
		N.placeIterator();
		N.addIterator(10);
		N.advanceIterator();
		assertEquals(10, N.getIterator());
		N.addLast(20);
		assertEquals(10, N.getIterator());
		N.addIterator(25);
		N.advanceIterator();
		N.advanceIterator();
		assertEquals(20, N.getIterator());
	}
}
