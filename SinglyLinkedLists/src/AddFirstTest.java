import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddFirstTest {

	@Test
	void test() {
		 List<Integer> M = new List<>();
	        M.addFirst(1);
	        assertEquals(1, M.getFirst());
	        M.addFirst(2);
	        assertEquals(2, M.getFirst());       
	        M.addFirst(3);
	        assertEquals(3, M.getFirst());
	}

}
