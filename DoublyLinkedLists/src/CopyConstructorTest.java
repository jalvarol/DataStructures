import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CopyConstructorTest {

	@Test
	void test() {

		List<Integer> A = new List<>();
		for (int i = 0; i <= 10; i++) {
			A.addLast(i);
		}
		List<Integer> Acopy = new List<>(A);
		Acopy = new List<>(A);
		assertEquals(10, Acopy.getLast());

		List<Integer> B = new List<>();
		for (int i = 0; i <= 25; i++) {
			B.addLast(i);
		}
		List<Integer> Bcopy = new List<>(B);
		Bcopy = new List<>(B);
		assertEquals(25, Bcopy.getLast());

		List<Integer> C = new List<>();
		for (int i = 0; i <= 250; i++) {
			C.addLast(i);
		}
		List<Integer> Ccopy = new List<>(C);
		Ccopy = new List<>(C);
		assertEquals(250, Ccopy.getLast());
	}

}
