import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EqualsTest {

	@Test
	void test() {

		List<Integer> A = new List<>();
		for (int i = 0; i <= 10; i++) {
			A.addLast(i);
		}
		List<Integer> Acopy = new List<>(A);
		Acopy = new List<>(A);
		assertTrue(A.equals(Acopy));

		for (int i = 0; i < 5; i++) {
			A.removeLast();
		}
		assertFalse(A.equals(Acopy));
		for (int i = 6; i <= 10; i++) {
			A.addLast(i);
		}

		assertTrue(A.equals(Acopy));

	}

}
