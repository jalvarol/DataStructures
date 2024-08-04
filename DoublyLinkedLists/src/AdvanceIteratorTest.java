import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AdvanceIteratorTest {
	@Test
	void test() {
		List<Integer> O = new List<>();
		O.addFirst(1);
		O.addLast(2);
		O.addLast(3);
		O.placeIterator();
		O.advanceIterator();
		assertEquals(2, O.getIterator());
		O.advanceIterator();
		assertEquals(3, O.getIterator());
		O.addLast(4);
		O.advanceIterator();
		assertEquals(4, O.getIterator());
	}
}
