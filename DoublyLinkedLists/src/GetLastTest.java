import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetLastTest {

	@Test
	void test() {
		List<Integer> O = new List<>();
		O.addLast(1);
		assertEquals(1, O.getLast());
		O.addLast(2);
		assertEquals(2, O.getLast());
		O.addLast(3);
		assertEquals(3, O.getLast());
	}

}
