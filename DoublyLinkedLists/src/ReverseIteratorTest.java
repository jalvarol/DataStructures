import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReverseIteratorTest {

	@Test
	void test() {
		List<Integer> I = new List<>();
		I.addFirst(1);
		I.addLast(2);
		I.placeIterator();
		I.advanceIterator();
		I.reverseIterator();
		assertEquals(1, I.getIterator());
		I.advanceIterator();
		I.addIterator(10);
		I.reverseIterator();
		assertEquals(1, I.getIterator());
		I.advanceIterator();
		I.reverseIterator();
		assertEquals(1, I.getIterator());
	}
}
