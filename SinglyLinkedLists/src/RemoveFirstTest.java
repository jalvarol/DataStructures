import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RemoveFirstTest {

	@Test
	void test() {
		 List<Integer> P = new List<>();
	        P.addFirst(4);
	        P.addFirst(2);
	        P.removeFirst();
	        assertEquals(4, P.getFirst());
	        P.addFirst(6);
	        P.addFirst(7);
	        P.addFirst(2);
	        P.removeFirst();
	        assertEquals(7, P.getFirst());       
	        P.removeFirst();
	        assertEquals(6, P.getFirst());
	}

}
