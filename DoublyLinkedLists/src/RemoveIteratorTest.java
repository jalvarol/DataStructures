import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RemoveIteratorTest {

	@Test
	void test() {
		List<Integer> R = new List<>();
		R.addFirst(10);
		R.addLast(15);
		R.addFirst(25);
		R.placeIterator();
		R.removeIterator();
		assertTrue(R.offEnd());
		R.placeIterator();
		R.removeIterator();
		assertTrue(R.offEnd());
		R.placeIterator();
		R.removeIterator();
		assertTrue(R.offEnd());
	}

}
