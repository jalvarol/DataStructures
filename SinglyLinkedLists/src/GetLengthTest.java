import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetLengthTest {

	@Test
	void test() {
        List<Integer> Q = new List<>();
        Q.addFirst(3);
        Q.addFirst(5);
        assertEquals(2, Q.getLength());
        Q.addLast(3);
        assertEquals(3, Q.getLength());
        Q.addFirst(2);
        Q.addLast(5);
        assertEquals(5, Q.getLength());
	}

}
