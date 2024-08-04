import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlaceIteratorTest {

	@Test
	void test() {
		List<Integer> Q = new List<>();
		Q.addFirst(1);
		Q.addFirst(5);
		Q.placeIterator();
		assertEquals(5, Q.getIterator());
		Q.removeIterator();
		Q.addFirst(12);
		Q.addFirst(15);
		Q.placeIterator();
		assertEquals(15, Q.getIterator());
		Q.removeIterator();
		Q.addFirst(224);
		Q.placeIterator();
		assertEquals(224, Q.getIterator());
	}

}
