import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetFrontTest {

	@Test
	void test() {
		Queue<Integer> C = new Queue<>();
		C.enqueue(10);
		C.enqueue(20);
		C.enqueue(30);
		C.enqueue(40);
		C.dequeue();
		assertEquals(20, C.getFront());
		C.dequeue();
		assertEquals(30, C.getFront());
		C.dequeue();
		assertEquals(40, C.getFront());
	}

}
