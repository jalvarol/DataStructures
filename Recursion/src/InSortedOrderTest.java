import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InSortedOrderTest {

	@Test
	void test() {
		List<Integer>A = new List<>();
		A.addFirst(1);
		A.addLast(5);
		assertTrue(A.inSortedOrder());
		A.addFirst(10);
		assertFalse(A.inSortedOrder());
		A.removeFirst();
		A.addLast(10);
		assertTrue(A.inSortedOrder());
	}

}
